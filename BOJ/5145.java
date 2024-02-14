import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int stationCnt = Integer.parseInt(br.readLine());
            int[] costs = new int[stationCnt];
            for (int i = 1; i < stationCnt; i++) {
                costs[i] = Integer.parseInt(br.readLine());
            }

            HashMap<String, Integer> stationNames = new HashMap<>();
            for (int i = 0; i < stationCnt; i++) {
                String stationName = br.readLine();
                stationNames.put(stationName, i);
            }

            String startingStation = br.readLine();
            String endingStation = br.readLine();

            int startingStationIdx = stationNames.get(startingStation);
            int endingStationIdx = stationNames.get(endingStation);

            int absDiff = Math.abs(startingStationIdx - endingStationIdx);

            sb.append("Data Set ").append(tc).append(":\n").append(costs[absDiff]).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
