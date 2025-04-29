package app;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce {
    private static final Set<String> POPULARWORDS = new HashSet<>(List.of(
            FileManager.readFile
                    ("C:\\UMBRA\\Java\\Projects\\CaesarCipherApp\\resourсes\\10000-russian-words.txt")
                    .split("\\s")));

    public static String decryptByBruteForce(String encryptedText) {
        char[] alphabet = Cipher.getAlphabet();
        String decryptedText = null;
        int matches = 0;
        for (int i = 0; i < alphabet.length; i++) {
            String text = Cipher.decrypt(encryptedText, i);
            int matchesInText = checkingMatches(text);
            if(matchesInText > matches) {
                decryptedText = text;
                matches = matchesInText;
            }
        }
        return decryptedText;
    }

    public static int checkingMatches(String text) {
        Set<String> words = new HashSet<>(Arrays.asList(text.split("[\\s\\p{Punct}]")));
        int matches = 0;
        for (String word: words) {
            if (POPULARWORDS.contains(word)) {
                matches++;
            }
        }


        return matches;
    }


}
