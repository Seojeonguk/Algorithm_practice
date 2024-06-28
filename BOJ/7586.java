import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

    static final int UPGRADE_POINT = 200;
    static final Map<Character, Integer> SERVICE_PROBLEM = Map.of(
            'L', 120,
            'S', 150,
            'B', 150,
            'N', 40,
            'C', 160,
            'D', 100,
            'R', 100,
            'O', 100
    );

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                String flightNum = br.readLine();
                if ("#".equals(flightNum)) {
                    break;
                }

                HashMap<String, Integer> passengers = new HashMap<>();
                while (true) {
                    StringTokenizer passengerToken = new StringTokenizer(br.readLine());
                    String seatNum = passengerToken.nextToken();
                    if ("00A".equals(seatNum)) {
                        break;
                    }

                    char code = passengerToken.nextToken().charAt(0);
                    int point = passengers.getOrDefault(seatNum, 0) + SERVICE_PROBLEM.getOrDefault(code, 0);
                    passengers.put(seatNum, point);
                }

                int upgradeAwardedCnt = 0;
                Collection<Integer> points = passengers.values();
                for (int point : points) {
                    if (point >= UPGRADE_POINT) {
                        upgradeAwardedCnt++;
                    }
                }

                sb.append(flightNum).append(" ").append(upgradeAwardedCnt).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
