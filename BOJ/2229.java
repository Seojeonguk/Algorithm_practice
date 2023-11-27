import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int participantCnt = Integer.parseInt(br.readLine());

        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[participantCnt + 1];

        for (int i = 0; i < participantCnt; i++) {
            int min = scores[i], max = scores[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, scores[j]);
                max = Math.max(max, scores[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + Math.abs(max - min));
            }
        }

        sb.append(dp[participantCnt]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
