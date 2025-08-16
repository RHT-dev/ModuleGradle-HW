package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

public class XlsWriter {
    private static final Logger logger = LogManager.getLogger(XlsWriter.class.getName());

    public static void generateExcelStatistics(Collection<Statistics> statisticsList, String filePath) {
        logger.info("Начало генерации Excel-файла: {}", filePath);
        if (statisticsList == null || statisticsList.isEmpty()) {
            logger.warn("Передана пустая коллекция статистики. Файл не будет создан.");
            return;
        }
        Workbook workbook = new XSSFWorkbook();
        try {
            Sheet sheet = workbook.createSheet("Project. Task 27.8");
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerStyle.setFont(headerFont);

            String[] headers = {"Профиль обучения", "Средний балл", "Кол-во студентов", "Кол-во университетов", "Университеты"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int rowNum = 1;
            for (Statistics stat : statisticsList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(stat.getStudyProfile());
                row.createCell(1).setCellValue(stat.getAvgExamScore());
                row.createCell(2).setCellValue(stat.getStudentCountInProfile());
                row.createCell(3).setCellValue(stat.getUniversityCountInProfile());
                row.createCell(4).setCellValue(String.join(", ", stat.getUniversityNames()));
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
            logger.info("Excel-файл успешно создан: {}", filePath);
        } catch (IOException e) {
            logger.error("Ошибка при записи Excel-файла: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Неожиданная ошибка при генерации Excel-файла: {}", e.getMessage(), e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                logger.warn("Ошибка при закрытии Workbook: {}", e.getMessage(), e);
            }
        }
    }
}