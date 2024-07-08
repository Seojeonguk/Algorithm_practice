import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static String[] CHARACTERS = {"A", "B", "C", "D", "F"};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String letter = br.readLine();
            sb.append(fixLetter(letter));

            bw.write(sb.toString());
        }
    }

    public static String fixLetter(String letter) {
        for (int i = 0; i < 3; i++) {
            if (letter.contains(CHARACTERS[i])) {
                for (int j = i + 1; j < CHARACTERS.length; j++) {
                    letter = letter.replaceAll(CHARACTERS[j], CHARACTERS[i]);
                }
                return letter;
            }
        }

        return "A".repeat(letter.length());
    }
}
