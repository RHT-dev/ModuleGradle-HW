import model.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // настройка логгера через logging.properties
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("logging.properties")) {
            if (is != null) {
                LogManager.getLogManager().readConfiguration(is);
            } else {
                System.err.println("Не найден logging.properties в ресурсах!");
            }
        } catch (IOException e) {
            System.err.println("Ошибка загрузки logging.properties: " + e.getMessage());
        }

        try {
            List<Student> students = ExcelReader.studentReader();
            logger.info("Данные о студентах успешно считаны. Количество: " + students.size());
            List<University> universities = ExcelReader.universityReader();
            logger.info("Данные об университетах успешно считаны. Количество: " + universities.size());

            var statistics = StatisticsUtil.collectStatistics(students, universities);
            logger.info("Статистика собрана. Профилей: " + statistics.size());
            XlsWriter.generateExcelStatistics(statistics, "statistics.xlsx");
            logger.info("Файл statistics.xlsx успешно создан.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при работе с ФАЙЛАМИ: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "ОШИБКА: " + e.getMessage(), e);
        }
    }
}
