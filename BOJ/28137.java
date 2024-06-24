import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int placeCnt = Integer.parseInt(st.nextToken());
            long slope = Long.parseLong(st.nextToken());

            TreeMap<Long, Long> points = new TreeMap<>();
            for (int i = 0; i < placeCnt; i++) {
                StringTokenizer coordinates = new StringTokenizer(br.readLine());
                long x = Long.parseLong(coordinates.nextToken());
                long y = Long.parseLong(coordinates.nextToken());

                long equation = y - slope * x;
                long cnt = points.getOrDefault(equation, 0L);
                points.put(equation, cnt + 1);
            }

            long ans = 0;
            for (Map.Entry<Long, Long> set : points.entrySet()) {
                ans += (set.getValue() * (set.getValue() - 1));
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
