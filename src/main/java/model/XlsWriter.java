package model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;


// пункт 2
public class XlsWriter {
    public static void generateExcelStatistics(Collection<Statistics> statisticsList, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Project. Task 27.8");

        // реализация пункта 3:
        // "В методе генерации нужно реализовать с помощью Apache POI создание нового Workbook.
        // Добавить на него новую страницу.
        // В странице заполнить заголовок с текстовыми наименованиями (то есть подписать колонки таблицы).
        // Заголовки должны иметь настроенный стиль — как минимум,
        // сделать всё жирным шрифтом и с указанным размером шрифта."
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

        // пункт 4:
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

        // пункт 5:
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
    }
}