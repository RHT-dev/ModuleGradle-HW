import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

    private ExcelReader(){};

    // метод для чтения студентов
    public static List<Student> studentReader() throws IOException {
        List<Student> students = new ArrayList<>();

        InputStream inputStream = ExcelReader.class
                .getResourceAsStream("universityinfo.xlsx");

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Студенты");
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Student student = new Student()
                    .setFullName(row.getCell(0).getStringCellValue())
                    .setUniversityId(row.getCell(1).getStringCellValue())
                    .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                    .setAvgExamScore((float) row.getCell(3).getNumericCellValue());

            students.add(student);
        }
        return students;
    };

    // метод для чтения университетов
    public static List<University> universityReader() throws IOException {
        List<University> universities = new ArrayList<>();

        InputStream inputStream = ExcelReader.class
                .getResourceAsStream("universityinfo.xlsx");

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet("Университеты");
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            University university = new University()
                    .setId(row.getCell(0).getStringCellValue())
                    .setFullName(row.getCell(1).getStringCellValue())
                    .setShortName(row.getCell(2).getStringCellValue())
                    .setYearOfFoundation((int) row.getCell(3).getNumericCellValue());

            String profileStr = row.getCell(4).getStringCellValue();
            university.setMainProfile(StudyProfile.valueOf(profileStr));

            universities.add(university);
        }
        return universities;
    };
}
