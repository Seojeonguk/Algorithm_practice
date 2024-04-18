import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int electronicDeviceCnt = Integer.parseInt(st.nextToken());
            int concentricPlugCnt = Integer.parseInt(st.nextToken());

            int[] chargingTimes = new int[electronicDeviceCnt];
            StringTokenizer chargingTimeInfo = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < electronicDeviceCnt; idx++) {
                chargingTimes[idx] = Integer.parseInt(chargingTimeInfo.nextToken());
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.nCopies(concentricPlugCnt, 0));

            Arrays.stream(chargingTimes).boxed().sorted(Comparator.reverseOrder()).forEach(chargingTime -> {
                int top = pq.poll();
                pq.add(top + chargingTime);
            });

            int maxTime = pq.stream().mapToInt(Integer::intValue).max().getAsInt();
            sb.append(maxTime);

            bw.write(sb.toString());
        }
    }
}
