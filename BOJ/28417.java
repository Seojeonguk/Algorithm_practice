import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int playerCnt = Integer.parseInt(br.readLine());

        int[] scores = new int[7];

        int maxScore = 0;
        for (int player = 0; player < playerCnt; player++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < scores.length; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, 2, scores.length);
            
            int score = Math.max(scores[0], scores[1]) + scores[5] + scores[6];
            maxScore = Math.max(maxScore, score);
        }

        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
