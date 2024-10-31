import java.util.*;
import java.lang.*;

class Translit {

    private static final Map<String, String> letters = new HashMap<String, String>();

    Translit() {
        letters.put("А", "A");
        letters.put("В", "B");
        letters.put("Т", "T");
        letters.put("Н", "H");
        letters.put("М", "M");
        letters.put("К", "K");
        letters.put("Е", "E");
        letters.put("Х", "X");
        letters.put("Р", "P");
        letters.put("О", "O");
        letters.put("С", "C");
    }

    public String toTranslit(String tag) {
        StringBuilder sb = new StringBuilder(tag.length());
        for (int i = 0; i < tag.length(); i++) {
            String l = tag.substring(i, i + 1);
            if (letters.containsKey(l)) {
                sb.append(letters.get(l));
            } else {
                sb.append(l);
            }
        }
        return sb.toString();
    }

    public static boolean isTagContainsEngSymbol(String tag) {
        for (int i = 0; i < tag.length(); i++) {
            if (Character.UnicodeBlock.of(tag.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
                return false;
            }
        }
        return true;
    }

    public String replaceRusOnEng(String tag) {
        if (!isTagContainsEngSymbol(tag)) {
            toTranslit(tag);
        }
        return tag;
    }
}
