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

        int totalScore = 0;
        int currentScore = 0;

        for (int idx = 0; idx < str.length; idx++) {
            if (idx == 0 || str[idx - 1] >= str[idx]) {
                currentScore = 1;
            } else {
                currentScore += 1;
            }
            totalScore += currentScore;
        }

        sb.append(totalScore);

        bw.write(sb.toString());
        bw.flush();
    }
}
