import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KeypadTranslatorService translator = new KeypadTranslatorService();

        List<String> testCodes = new ArrayList<>();
        testCodes.add("4433555-555666 96667775553");
        testCodes.add("2-22-22-2");
        testCodes.add("25552 62 5566682");

        testCodes.forEach(code ->
            System.out.println(code + " -> " + translator.translate(code))
        );
    }
}