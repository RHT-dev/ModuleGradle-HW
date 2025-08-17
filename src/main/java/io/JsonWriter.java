package io;

import model.Root;
import util.JsonUtil;
import java.io.File;
import java.io.FileWriter;

public class JsonWriter {
    public static void writeToJson(Root root) throws Exception {
        File dir = new File("jsonReqs");
        if (!dir.exists()) dir.mkdirs();
        String processedAt = root.getProcessedAt();
        if (processedAt == null || processedAt.isEmpty()) {
            processedAt = String.valueOf(System.currentTimeMillis());
        }
        String fileName = "req_" + processedAt + ".json";
        File file = new File(dir, fileName);
        String json = JsonUtil.serializeRoot(root);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        }
    }
}
