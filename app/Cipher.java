package app;

public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static String encrypt(String text, int shift) {
        char[] chars = text.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!containsAlphabet(chars[i])) {
                continue;
            }
            chars[i] = ALPHABET[(findIndex(chars[i]) + shift) % ALPHABET.length];

        }
        return new String(chars);
    }

    public static String decrypt(String encryptedText, int shift) {
        char[] chars = encryptedText.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!containsAlphabet(chars[i])) {
                continue;
            }
            chars[i] = ALPHABET[(findIndex(chars[i]) - shift + ALPHABET.length) % ALPHABET.length];

        }
        return new String(chars);
    }

    private static boolean containsAlphabet(char target) {
        for (char c : ALPHABET) {
            if (c == target) return true;
        }
        return false;
    }

    public static char[] getAlphabet() {
        return ALPHABET;
    }

    private static int findIndex(char target) {
        int index = 0;
        for (int i = 0; i < ALPHABET.length; i++) {
            if (target == ALPHABET[i]) {
                index = i;
            }
        }
        return index;
    }

}
