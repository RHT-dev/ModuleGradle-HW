package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Student;
import model.University;
import java.util.Collection;

public class JsonUtil {
    private JsonUtil() {}

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String serializeStudent(Student student) {
        return GSON.toJson(student);
    }

    public static String serializeUniversity(University university) {
        return GSON.toJson(university);
    }

    public static String serializeRoot(model.Root root) {
        return GSON.toJson(root);
    }

    public static String serializeCollection(Collection<?> collection) {
        return GSON.toJson(collection);
    }
}
