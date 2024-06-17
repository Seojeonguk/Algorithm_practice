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
            int lateTime = Integer.parseInt(st.nextToken());

            int latestArrivalTime = -1;
            for (int busNum = 0; busNum < busCnt; busNum++) {
                StringTokenizer bus = new StringTokenizer(br.readLine());
                int arrivalTime = Integer.parseInt(bus.nextToken());
                int moveTime = Integer.parseInt(bus.nextToken());

                if (arrivalTime + moveTime <= lateTime) {
                    latestArrivalTime = Math.max(latestArrivalTime, arrivalTime);
                }
            }

            sb.append(latestArrivalTime);

            bw.write(sb.toString());
        }
    }
}
