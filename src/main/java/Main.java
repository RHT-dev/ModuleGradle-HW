import io.ExcelReader;
import io.XmlWriter;
import model.*;
import util.StatisticsUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Student> students = ExcelReader.studentReader();
            List<University> universities = ExcelReader.universityReader();
            var statistics = StatisticsUtil.collectStatistics(students, universities);

            Root root = new Root();
            root.setStudentsInfo(students);
            root.setUniversitiesInfo(universities);
            root.setStatisticalInfo(statistics);
            root.setProcessedAt(String.valueOf(System.currentTimeMillis()));

            XmlWriter.writeToXml(root);
            io.JsonWriter.writeToJson(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
