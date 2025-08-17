package util;

import model.Statistics;
import model.Student;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private static final Logger logger = LogManager.getLogger(StatisticsUtil.class.getName());

    public static List<Statistics> collectStatistics(Collection<Student> students, Collection<University> universities) {
        logger.info("Начало сбора статистики по профилям обучения.");
        // Группируем университеты по профилю
        Map<String, List<University>> profileToUniversities = universities.stream()
                .filter(u -> u.getUniversityProfile() != null)
                .collect(Collectors.groupingBy(University::getUniversityProfile));

        if (profileToUniversities.isEmpty()) {
            logger.warn("В коллекции университетов нет ни одного профиля обучения.");
        }

        List<Statistics> statisticsList = new ArrayList<>();

        for (Map.Entry<String, List<University>> entry : profileToUniversities.entrySet()) {
            String profile = entry.getKey();
            List<University> unis = entry.getValue();
            Set<String> universityIds = unis.stream().map(University::getUniversityId).collect(Collectors.toSet());

            List<Student> studentsOfProfile = students.stream()
                    .filter(s -> universityIds.contains(s.getUniversityId()))
                    .collect(Collectors.toList());

            OptionalDouble avgExamScoreOpt = studentsOfProfile.stream()
                    .mapToDouble(Student::getAvgScore)
                    .average();

            double avgExamScore = avgExamScoreOpt.isPresent() ?
                    BigDecimal.valueOf(avgExamScoreOpt.getAsDouble()).setScale(2, RoundingMode.HALF_UP).doubleValue() : 0.0;

            Statistics stat = new Statistics(profile, avgExamScore);
            statisticsList.add(stat);
        }
        logger.info("Сбор статистики завершён. Количество профилей: {}", statisticsList.size());
        return statisticsList;
    }
}