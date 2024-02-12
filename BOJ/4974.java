import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int judgeCnt = Integer.parseInt(br.readLine());
            if (judgeCnt == 0) {
                break;
            }
            int[] scores = new int[judgeCnt];
            for (int i = 0; i < judgeCnt; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(scores);
            int totalScore = Arrays.stream(scores).sum();
            totalScore -= scores[0] + scores[judgeCnt - 1];

            sb.append(totalScore / (judgeCnt - 2)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
