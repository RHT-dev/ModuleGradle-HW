import model.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = ExcelReader.studentReader();
        List<University> universities = ExcelReader.universityReader();

        // сбор статистики и генерация XLSX-файла
        var statistics = StatisticsUtil.collectStatistics(students, universities);
        XlsWriter.generateExcelStatistics(statistics, "statistics.xlsx");
    }
}
