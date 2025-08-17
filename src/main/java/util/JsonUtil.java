package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {};

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String serializeStudent(Student student) {
       return GSON.toJson(student);
    };

    public static String serializeStudentList(List<Student> studentList) {
        return GSON.toJson(studentList);
    };

    public static String serializeUniversity(University university) {
        return GSON.toJson(university);
    };

    public static String serializeUniversityList(List<University> universityList) {
        return GSON.toJson(universityList);
    };

    public static Student deserializeStudent(String json) {
        return GSON.fromJson(json, Student.class);
    };

    public static List<Student> deserializeStudentList(String json) {
        Type studentListType = new TypeToken<List<Student>>(){}.getType();
        return GSON.fromJson(json, studentListType);
    };
    public static University deserializeUniversity(String json) {
        return GSON.fromJson(json, University.class);
    };
    public static List<University> deserializeUniversityList(String json) {
        Type universityListType = new TypeToken<List<University>>(){}.getType();
        return GSON.fromJson(json, universityListType);
    };
}
