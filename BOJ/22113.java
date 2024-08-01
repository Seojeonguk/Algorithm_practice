import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int busCnt = Integer.parseInt(st.nextToken());
            int usedBusCnt = Integer.parseInt(st.nextToken());

            int[] usedBuses = new int[usedBusCnt];
            StringTokenizer usedBusToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < usedBusCnt; i++) {
                usedBuses[i] = Integer.parseInt(usedBusToken.nextToken());
            }

            int[][] costs = new int[busCnt][busCnt];
            for (int i = 0; i < busCnt; i++) {
                StringTokenizer busCostToken = new StringTokenizer(br.readLine());
                for (int j = 0; j < busCnt; j++) {
                    costs[i][j] = Integer.parseInt(busCostToken.nextToken());
                }
            }

            int requiredCost = 0;
            for (int i = 0; i < usedBusCnt - 1; i++) {
                requiredCost += costs[usedBuses[i] - 1][usedBuses[i + 1] - 1];
            }

            sb.append(requiredCost);

            bw.write(sb.toString());
        }
    }
}
