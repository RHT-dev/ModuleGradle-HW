package io;

import model.Student;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    private static final Logger logger = LogManager.getLogger(ExcelReader.class.getName());

    private ExcelReader(){};

    // метод для чтения студентов
    public static List<Student> studentReader() throws IOException {
        List<Student> students = new ArrayList<>();

        InputStream inputStream = ExcelReader.class
                .getResourceAsStream("/universityInfo.xlsx");

        if (inputStream == null) {
            logger.error("Файл universityInfo.xlsx не найден в resources");
            throw new IOException("Файл universityInfo.xlsx не найден в resources");
        }

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Студенты");
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = new Student(
                    row.getCell(1).getStringCellValue(), // studentName
                    row.getCell(0).getStringCellValue(), // universityId
                    row.getCell(3).getNumericCellValue() // avgScore
            );
            students.add(student);
        }

        workbook.close();
        inputStream.close();
        logger.info("Прочитано студентов: {}", students.size());
        return students;
    };

    // метод для чтения университетов
    public static List<University> universityReader() throws IOException {
        List<University> universities = new ArrayList<>();

        InputStream inputStream = ExcelReader.class
                .getResourceAsStream("/universityInfo.xlsx");

        if (inputStream == null) {
            logger.error("Файл universityInfo.xlsx не найден в ресурсах");
            throw new IOException("Файл universityInfo.xlsx не найден в ресурсах");
        }

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Университеты");
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            University university = new University(
                    row.getCell(0).getStringCellValue(), // universityId
                    row.getCell(1).getStringCellValue(), // universityName
                    row.getCell(4).getStringCellValue()  // universityProfile
            );
            universities.add(university);
        }

        workbook.close();
        inputStream.close();
        logger.info("Прочитано университетов: {}", universities.size());
        return universities;
    };
}
