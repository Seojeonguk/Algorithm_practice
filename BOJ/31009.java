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

    static final String JINJU = "jinju";

    public static void main(String[] args) throws Exception {
        int totalTerminalTraffic = Integer.parseInt(br.readLine());
        int[] trafficCosts = new int[totalTerminalTraffic];
        int jinjuTrafficCost = -1;
        for (int i = 0; i < totalTerminalTraffic; i++) {
            st = new StringTokenizer(br.readLine());
            String destination = st.nextToken();
            int trafficCost = Integer.parseInt(st.nextToken());
            if (JINJU.equals(destination)) {
                jinjuTrafficCost = trafficCost;
            } else {
                trafficCosts[i] = trafficCost;
            }
        }

        int overJinjuTrafficCost = 0;
        for (int i = 0; i < totalTerminalTraffic; i++) {
            if (jinjuTrafficCost < trafficCosts[i]) {
                overJinjuTrafficCost++;
            }
        }

        sb.append(jinjuTrafficCost).append("\n").append(overJinjuTrafficCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
