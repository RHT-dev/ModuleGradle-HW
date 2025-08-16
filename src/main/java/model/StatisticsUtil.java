package model;

import enumeration.StudyProfile;

import java.util.*;
import java.util.stream.Collectors;

// пункт 6
public class StatisticsUtil {

    // пункт 7
    public static Collection<Statistics> collectStatistics(Collection<Student> students, Collection<University> universities) {

        Map<StudyProfile, List<University>> profileToUniversities = universities.stream()
                .filter(university -> university.getMainProfile() != null)
                .collect(Collectors.groupingBy(university -> university.getMainProfile()));

        List<Statistics> statisticsList = new ArrayList<>();

        for (Map.Entry<StudyProfile, List<University>> entry : profileToUniversities.entrySet()) {
            StudyProfile profile = entry.getKey();
            List<University> unis = entry.getValue();
            List<String> universityNames = unis.stream().map(University::getFullName).collect(Collectors.toList());
            Set<String> universityIds = unis.stream().map(University::getId).collect(Collectors.toSet());

            List<Student> studentsOfProfile = students.stream()
                    .filter(s -> universityIds.contains(s.getUniversityId()))
                    .collect(Collectors.toList());

            float avgExamScore = 0;
            if (!studentsOfProfile.isEmpty()) {
                avgExamScore = (float) studentsOfProfile.stream().mapToDouble(Student::getAvgExamScore).average().orElse(0);
            }

            Statistics stat = new Statistics(
                    profile.getProfileName(),
                    avgExamScore,
                    studentsOfProfile.size(),
                    unis.size(),
                    universityNames
            );
            statisticsList.add(stat);
        }
        return statisticsList;
    }
}