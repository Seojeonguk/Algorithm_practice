import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer intTokenizer = new StringTokenizer(br.readLine());
            int trailLength = Integer.parseInt(intTokenizer.nextToken());
            int restStopsNum = Integer.parseInt(intTokenizer.nextToken());
            int farmerSpeed = Integer.parseInt(intTokenizer.nextToken());
            int bessieSpeed = Integer.parseInt(intTokenizer.nextToken());

            int[][] restStops = new int[restStopsNum][2];
            for (int restStopNum = 0; restStopNum < restStopsNum; restStopNum++) {
                StringTokenizer restStopTokenizer = new StringTokenizer(br.readLine());
                restStops[restStopNum][0] = Integer.parseInt(restStopTokenizer.nextToken());
                restStops[restStopNum][1] = Integer.parseInt(restStopTokenizer.nextToken());
            }

            Arrays.sort(restStops, (o1, o2) -> Integer.compare(o2[1], o1[1]));

            long maxTastiness = 0;
            int latestRestStop = 0;
            long prevFarmerTime = 0;
            for (int restStopNum = 0; restStopNum < restStopsNum; restStopNum++) {
                if (latestRestStop > restStops[restStopNum][0]) {
                    continue;
                }

                long farmerTime = (long) restStops[restStopNum][0] * farmerSpeed;
                long bessieTime = (long) (restStops[restStopNum][0] - latestRestStop) * bessieSpeed + prevFarmerTime;
                prevFarmerTime = farmerTime;

                maxTastiness += (farmerTime - bessieTime) * restStops[restStopNum][1];
                latestRestStop = restStops[restStopNum][0];
            }

            sb.append(maxTastiness);

            bw.write(sb.toString());
        }
    }
}
