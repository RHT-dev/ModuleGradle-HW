import model.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = ExcelReader.studentReader();
        List<University> universities = ExcelReader.universityReader();

        // Практическая неделя 3. Проект.

        // пункт 4
        String studentsJson = JsonUtil.serializeStudentList(students);
        String universityJson = JsonUtil.serializeUniversityList(universities);

        System.out.println(studentsJson);
        System.out.println(universityJson + "\n");

        // пункт 5
        List<Student> deserializedStudents = JsonUtil.deserializeStudentList(studentsJson);
        List<University> deserializedUniversities = JsonUtil.deserializeUniversityList(universityJson);

        // пункт 6

        if (students.size() == deserializedStudents.size()) {
            System.out.printf("Количество студентов совпадает: %d\n", students.size());
        }
        else {
            System.out.println(">>> STUDENTS НЕ СОВПАДАЮТ");
        }

        if (universities.size() == deserializedUniversities.size()) {
            System.out.printf("Количество университетов совпадает: %d\n", universities.size());
        }
        else {
            System.out.println(">>> UNIVERSITIES НЕ СОВПАДАЮТ");
        }

        // пункты 7-10

        students.stream().forEach(student -> {
            // пункт 7: сериализация
            String json = JsonUtil.serializeStudent(student);

            // пункт 8: вывод JSON-строки
            System.out.println("Serialized JSON:\n" + json);

            // пункт 9: десериализация
            Student deserialized = JsonUtil.deserializeStudent(json);

            // пункт 10: вывод обратно полученного объекта
            System.out.println("Deserialized object:\n" + deserialized);
        });

        universities.stream().forEach(university -> {
            String json = JsonUtil.serializeUniversity(university);

            System.out.println("Serialized JSON:\n" + json);

            University deserialized = JsonUtil.deserializeUniversity(json);

            System.out.println("Deserialized object:\n" + deserialized);
        });


    }
}
