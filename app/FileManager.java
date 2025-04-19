package app;

import java.io.IOException;
import java.nio.file.*;

public class FileManager {
    public static String readFile(String filePath) {
        Path path = Path.of(filePath);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String content, String filePath) {
        Path path = Path.of(filePath);
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
