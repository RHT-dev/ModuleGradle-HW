import model.ExcelReader;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = ExcelReader.studentReader();
        List<University> universities = ExcelReader.universityReader();

        students.forEach(s -> System.out.println(s));
        universities.forEach(u -> System.out.println(u));
    }
}
