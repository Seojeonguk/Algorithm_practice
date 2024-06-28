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

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String busNum = st.nextToken();
                int maxPassenger = Integer.parseInt(st.nextToken());

                if ("#".equals(busNum)) {
                    break;
                }

                int passenger = Integer.parseInt(br.readLine());
                int busStopCnt = Integer.parseInt(br.readLine());
                for (int i = 0; i < busStopCnt; i++) {
                    StringTokenizer busStop = new StringTokenizer(br.readLine());
                    int gettingOff = Integer.parseInt(busStop.nextToken());
                    int gettingOn = Integer.parseInt(busStop.nextToken());

                    passenger = Math.min(maxPassenger, passenger - gettingOff + gettingOn);
                }

                sb.append(busNum).append(" ").append(passenger).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
