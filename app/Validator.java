package app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {

    public static int isValidKey(int key) {
        Scanner scanner = new Scanner(System.in);
        char[] alphabet = Cipher.getAlphabet();
        while (true) {
            if (key > 0 && key < alphabet.length) {
                break;
            } else {
                System.out.println("Ключ должен быть в диапазоне от 0 до " + alphabet.length + ".");
                System.out.print("Введите ключ повторно: ");
                key = Integer.parseInt(scanner.nextLine());
            }
        }
        return key;
    }

    public static String isFileExists(String filePath) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (Files.exists(Path.of(filePath))) {
                break;
            } else {
                System.out.println("Указан неверный путь.");
                System.out.print("Введите путь повторно: ");
                filePath = scanner.nextLine();
            }
        }
        return filePath;
    }
}
