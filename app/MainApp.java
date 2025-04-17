package app;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainApp {

    public static void main(String[] args) {
        String text = "Привет мой друг! Как твои дела?";
        String encryptedText = Cipher.encrypt(text, 6);
        System.out.println(encryptedText);
        System.out.println(Cipher.decrypt(encryptedText, 6));
        
    }
}
