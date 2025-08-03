import enumeration.StudentComparatorType;
import enumeration.UniversityComparatorType;
import model.ComparatorFabricUtil;
import model.ExcelReader;
import model.Student;
import model.University;
import studentComparator.StudentComparator;
import universityComparator.UniversityComparator;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = ExcelReader.studentReader();
        List<University> universities = ExcelReader.universityReader();

        // 1 вариант: сохранять как переменные конкретные компараторы, н-р:

        StudentComparator studentAvgExamScoreComparator = ComparatorFabricUtil
                .getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        UniversityComparator universityFullNameComparator = ComparatorFabricUtil
                .getUniversityComparator(UniversityComparatorType.FULL_NAME);

        System.out.println(">>> 1 ВАРИАНТ: ");

        students.stream()
                .sorted(studentAvgExamScoreComparator)
                .forEach(System.out::println);

        universities.stream()
                .sorted(universityFullNameComparator)
                .forEach(System.out::println);


        // 2 вариант: или сохранить все виды компараторов в Map и вызывать нужные где потребуется
        Map<StudentComparatorType, StudentComparator> studentComparators = new EnumMap<>(StudentComparatorType.class);
        for (StudentComparatorType type : StudentComparatorType.values()) {
            studentComparators.put(type, ComparatorFabricUtil.getStudentComparator(type));
        }

        Map<UniversityComparatorType, UniversityComparator> universityComparators = new EnumMap<>(UniversityComparatorType.class);
        for (UniversityComparatorType type : UniversityComparatorType.values()) {
            universityComparators.put(type, ComparatorFabricUtil.getUniversityComparator(type));
        }

        System.out.println(">>> 2 ВАРИАНТ: ");

        students.stream()
                .sorted(studentComparators.get(StudentComparatorType.FULL_NAME))
                .forEach(System.out::println);

        universities.stream()
                .sorted(universityComparators.get(UniversityComparatorType.FULL_NAME))
                .forEach(System.out::println);
    }
}
