package model;

import enumeration.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

// пункт 6
public class StatisticsUtil {

    // пункт 7
    public static Collection<Statistics> collectStatistics(Collection<Student> students, Collection<University> universities) {
        Map<StudyProfile, List<University>> profileToUniversities = universities.stream()
                .filter(university -> university.getMainProfile() != null)
                .collect(Collectors.groupingBy(University::getMainProfile));

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
        return statisticsList;
    }
}