import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int rangeCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < rangeCnt; i++) {
            int bridgeCnt = Integer.parseInt(br.readLine());

            int[] speeds = new int[bridgeCnt];
            int[] distances = new int[bridgeCnt];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < bridgeCnt; j++) {
                speeds[j] = Integer.parseInt(st.nextToken());
                distances[j] = Integer.parseInt(st.nextToken());
            }

            int fastestBridgeNum = 0;
            double fastestAvg = 10000;
            for (int j = 0; j < bridgeCnt; j++) {
                double avg = (double) distances[j] / speeds[j];
                if (avg < fastestAvg) {
                    fastestAvg = avg;
                    fastestBridgeNum = j;
                }
            }

            sb.append(fastestBridgeNum + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
