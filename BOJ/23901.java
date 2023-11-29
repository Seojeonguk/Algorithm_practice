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
            int checkpointCnt = Integer.parseInt(br.readLine());

            int[] checkpointHeights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int peakCnt = 0;

            for (int i = 1; i < checkpointCnt - 1; i++) {
                if (checkpointHeights[i - 1] < checkpointHeights[i] && checkpointHeights[i + 1] < checkpointHeights[i]) {
                    peakCnt++;
                }
            }

            sb.append(String.format("Case #%d: %d\n", tc, peakCnt));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
