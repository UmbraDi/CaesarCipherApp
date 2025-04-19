package app;

import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для шифрования: ");
        String text = FileManager.readFile(scanner.nextLine());
        String encryptedText = Cipher.encrypt(text, 6);
        System.out.print("Введите путь к файлу для записи: ");
        FileManager.writeFile(encryptedText, scanner.nextLine());
        System.out.print("Введите путь к файлу для дешифровки: ");
        FileManager.writeFile(Cipher.decrypt(encryptedText, 6), scanner.nextLine());
    }
}
