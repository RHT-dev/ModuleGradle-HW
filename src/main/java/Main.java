import io.ExcelReader;
import io.XmlWriter;
import io.JsonWriter;
import model.*;
import util.StatisticsUtil;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("Чтение данных о студентах");
            List<Student> students = ExcelReader.studentReader();
            logger.info("Чтение данных об университетах");
            List<University> universities = ExcelReader.universityReader();

            logger.info("Сбор статистики");
            var statistics = StatisticsUtil.collectStatistics(students, universities);

            logger.info("Создание корневого объекта Root");
            Root root = new Root();
            root.setStudentsInfo(students);
            root.setUniversitiesInfo(universities);
            root.setStatisticalInfo(statistics);
            root.setProcessedAt(String.valueOf(System.currentTimeMillis()));

            logger.info("Генерация XML-файла");
            XmlWriter.writeToXml(root);
            logger.info("XML-файл успешно создан");

            logger.info("Генерация JSON-файла");
            JsonWriter.writeToJson(root);
            logger.info("JSON-файл успешно создан");
        } catch (Exception e) {
            logger.severe("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
