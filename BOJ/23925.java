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
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            long totalStage = Long.parseLong(st.nextToken());
            long currentStage = Long.parseLong(st.nextToken());
            long swordStage = Long.parseLong(st.nextToken());

            long minTime = totalStage;
            if (currentStage > swordStage) {
                long initTime = currentStage + totalStage;
                long backStage = totalStage + 2 * currentStage - 2 * swordStage;

                minTime = Math.min(initTime, backStage);
            }

            sb.append(String.format("Case #%d: %d\n", tc, minTime));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
