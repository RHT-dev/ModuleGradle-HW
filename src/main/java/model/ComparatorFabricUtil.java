package model;

import enumeration.StudentComparatorType;
import enumeration.UniversityComparatorType;
import studentComparator.*;
import universityComparator.*;

public class ComparatorFabricUtil {

    private ComparatorFabricUtil(){};

    public static StudentComparator getStudentComparator(StudentComparatorType comparatorType) {
        return switch (comparatorType) {
            case FULL_NAME -> new StudentFullNameComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case CURRENT_COURSE_NUMBER -> new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
        };
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType comparatorType) {
        return switch (comparatorType) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearComparator();
            case MAIN_PROFILE -> new UniversityProfileComparator();
        };
    }
}
