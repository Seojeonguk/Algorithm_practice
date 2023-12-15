import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final String CORRECT = "Correct";
    static final String INCORRECT = "Incorrect";

    public static void main(String[] args) throws Exception {
        char[] login = br.readLine().toCharArray();

        sb.append(isCorrectLogin(login));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String isCorrectLogin(char[] login) {
        if (login.length < 3) {
            return INCORRECT;
        }
        if (login[0] != 'i' || login[1] != 'o') {
            return INCORRECT;
        }
        for (int i = 2; i < login.length; i++) {
            if (!Character.isDigit(login[i])) {
                return INCORRECT;
            }
        }

        return CORRECT;
    }
}
