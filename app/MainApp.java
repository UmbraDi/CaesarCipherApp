package app;

import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isReady = true;

        while (isReady) {
            System.out.print("""
                    Меню:
                    1: Зашифровать текст.
                    2: Расшифровать текст по ключу.
                    3: Расшифровать текст методом брутфорса.
                    0: Выйти из программы.
                    
                    Выберете пункт меню:
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    encrypt();
                    break;
                case 2:
                    decrypt();
                    break;
                case 3:
                    decryptedByBruteForce();
                    break;
                case 0:
                    System.out.println("Выход произведен.");
                    isReady = false;
            }
        }
    }

    public static void encrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String sourceFile = Validator.isFileExists(scanner.nextLine());
        String text = FileManager.readFile(sourceFile);
        System.out.print("Введите ключ: ");
        int key = Validator.isValidKey(Integer.parseInt(scanner.nextLine()));
        String encryptedText = Cipher.encrypt(text, key);
        System.out.print("Введите путь к файлу для записи зашифрованного текста: ");
        FileManager.writeFile(encryptedText, scanner.nextLine());
        System.out.println("Готово!");
        System.out.println();
    }

    public static void decrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для дешифровки: ");
        String sourceFile = Validator.isFileExists(scanner.nextLine());
        String encryptedText = FileManager.readFile(sourceFile);
        System.out.print("Введите ключ: ");
        int key = Validator.isValidKey(Integer.parseInt(scanner.nextLine()));
        System.out.print("Введите путь к файлу для записи расшифрованного текста: ");
        FileManager.writeFile(Cipher.decrypt(encryptedText, key), scanner.nextLine());
        System.out.println("Готово!");
        System.out.println();
    }

    public static void decryptedByBruteForce() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для дешифровки брутфорсом: ");
        String sourceFile = Validator.isFileExists(scanner.nextLine());
        String encryptedText = FileManager.readFile(sourceFile);
        System.out.print("Введите путь к файлу для записи расшифрованного текста: ");
        String decryptedByBruteForce = BruteForce.decryptByBruteForce(encryptedText);
        FileManager.writeFile(decryptedByBruteForce, scanner.nextLine());
        System.out.println("Готово!");
        System.out.println();
    }
}
