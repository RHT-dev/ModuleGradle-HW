package util;

import enumeration.StudentComparatorType;
import enumeration.UniversityComparatorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import studentComparator.*;
import universityComparator.*;

public class ComparatorFabricUtil {
    private static final Logger logger = LogManager.getLogger(ComparatorFabricUtil.class.getName());

    public static StudentComparator getStudentComparator(StudentComparatorType type) {
        logger.info("Выбор компаратора для студентов: {}", type);
        switch (type) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case CURRENT_COURSE_NUMBER:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                logger.error("Неизвестный тип компаратора для студентов: {}", type);
                throw new IllegalArgumentException("Unknown StudentComparatorType: " + type);
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType type) {
        logger.info("Выбор компаратора для университетов: {}", type);
        switch (type) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearComparator();
            case MAIN_PROFILE:
                return new UniversityProfileComparator();
            default:
                logger.error("Неизвестный тип компаратора для университетов: {}", type);
                throw new IllegalArgumentException("Unknown UniversityComparatorType: " + type);
        }
    }
}
