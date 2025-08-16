import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            List<Student> students = ExcelReader.studentReader();
            logger.info("Данные о студентах успешно считаны. Количество: {}", students.size());
            List<University> universities = ExcelReader.universityReader();
            logger.info("Данные об университетах успешно считаны. Количество: {}", universities.size());

            var statistics = StatisticsUtil.collectStatistics(students, universities);
            logger.info("Статистика собрана. Профилей: {}", statistics.size());
            XlsWriter.generateExcelStatistics(statistics, "statistics.xlsx");
            logger.info("Файл statistics.xlsx успешно создан.");
        } catch (IOException e) {
            logger.error("Ошибка при работе с ФАЙЛАМИ: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("ОШИБКА: {}", e.getMessage(), e);
        }
    }
}
