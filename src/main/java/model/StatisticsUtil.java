package model;

import enumeration.StudyProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private static final Logger logger = LogManager.getLogger(StatisticsUtil.class.getName());

    public static Collection<Statistics> collectStatistics(Collection<Student> students, Collection<University> universities) {
        logger.info("Начало сбора статистики по профилям обучения.");
        Map<StudyProfile, List<University>> profileToUniversities = universities.stream()
                .filter(university -> university.getMainProfile() != null)
                .collect(Collectors.groupingBy(University::getMainProfile));

        if (profileToUniversities.isEmpty()) {
            logger.warn("В коллекции университетов нет ни одного профиля обучения.");
        }

        List<Statistics> statisticsList = new ArrayList<>();

        for (Map.Entry<StudyProfile, List<University>> entry : profileToUniversities.entrySet()) {
            StudyProfile profile = entry.getKey();
            List<University> unis = entry.getValue();
            List<String> universityNames = unis.stream().map(University::getFullName).collect(Collectors.toList());
            Set<String> universityIds = unis.stream().map(University::getId).collect(Collectors.toSet());

            List<Student> studentsOfProfile = students.stream()
                    .filter(s -> universityIds.contains(s.getUniversityId()))
                    .collect(Collectors.toList());

            OptionalDouble avgExamScoreOpt = studentsOfProfile.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            Float avgExamScore = null;
            if (avgExamScoreOpt.isPresent()) {
                BigDecimal bd = BigDecimal.valueOf(avgExamScoreOpt.getAsDouble());
                bd = bd.setScale(2, RoundingMode.HALF_UP); // округление до двух знаков после запятой
                avgExamScore = bd.floatValue();
            }

            Statistics stat = new Statistics(
                    profile.getProfileName(),
                    avgExamScore != null ? avgExamScore : 0f,
                    studentsOfProfile.size(),
                    unis.size(),
                    universityNames
            );
            statisticsList.add(stat);
        }
        logger.info("Сбор статистики завершён. Количество профилей: {}", statisticsList.size());
        return statisticsList;
    }
}