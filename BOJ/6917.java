import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String ESCAPE_WORD = "quit!";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String word = br.readLine();
            if (ESCAPE_WORD.equals(word)) {
                break;
            }

            if (isAmericanSpelling(word)) {
                sb.append(word, 0, word.length() - 2).append("our").append("\n");
            } else {
                sb.append(word).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isAmericanSpelling(String word) {
        if (word.length() < 4) {
            return false;
        }

        if (!word.endsWith("or") || !isConsonant(word.charAt(word.length() - 3))) {
            return false;
        }

        return true;
    }

    public static boolean isConsonant(char c) {
        return (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y');
    }
}
