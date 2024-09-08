import java.util.HashMap;
import java.util.Map;

public class KeypadTranslatorService {

    private final Map<Integer, char[]> keypadMap = new HashMap<>(); // initial capacity min of 16 elements

    public KeypadTranslatorService() {
        initKeypadMap();
    }

    public String translate(final String text) {
        String[] words = text.split(" ");
        StringBuilder builder = new StringBuilder();

        int i = 0;
        int endOfText = words.length - 1;
        while (true) {
            translateWord(words[i], builder);
            i++;
            if (i > endOfText) {
                break;
            }
            builder.append(" ");
        }

        return builder.toString();
    }

    private void translateWord(final String word, final StringBuilder builder) {
        char[] arrKeys = word.trim().toCharArray();
        char tmp = arrKeys[0];
        int count = -1;

        for (char key : arrKeys) {
            if (key == tmp) {
                count++;
                continue;
            }
            addMappedLetter(tmp, count, builder);
            count = 0;
            tmp = key;
        }
        addMappedLetter(tmp, count, builder);
    }

    private void addMappedLetter(char key, int count, StringBuilder builder) {
        char[] letters = keypadMap.get(Character.getNumericValue(key));
        if (letters == null) {
            return;
        }

        if (letters.length > count) {
            builder.append(letters[count]);
            return;
        }

        builder.append(letters[count % letters.length]);
    }

    private void initKeypadMap() {
        keypadMap.put(2, new char[]{'a', 'b', 'c'});
        keypadMap.put(3, new char[]{'d', 'e', 'f'});
        keypadMap.put(4, new char[]{'g', 'h', 'i'});
        keypadMap.put(5, new char[]{'j', 'k', 'l'});
        keypadMap.put(6, new char[]{'m', 'n', 'o'});
        keypadMap.put(7, new char[]{'p', 'q', 'r', 's'});
        keypadMap.put(8, new char[]{'t', 'u', 'v'});
        keypadMap.put(9, new char[]{'w', 'x', 'y', 'z'});
    }
}
