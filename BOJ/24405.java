import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();

        sb.append(isCorrect(str) ? "correct" : "fix");

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isCorrect(char[] str) {
        if (str.length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < str.length / 2 - 1; i++) {
            if (str[i] != str[str.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
