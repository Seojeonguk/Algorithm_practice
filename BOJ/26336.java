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

            int trips = Integer.parseInt(br.readLine());

            for (int trip = 0; trip < trips; trip++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int totalMiles = Integer.parseInt(st.nextToken());
                int stopForGasPerMile = Integer.parseInt(st.nextToken());
                int stopForFoodPerMile = Integer.parseInt(st.nextToken());

                int stopCnt = 0;
                for (int mile = 1; mile < totalMiles; mile++) {
                    if (mile % stopForGasPerMile == 0 || mile % stopForFoodPerMile == 0) {
                        stopCnt++;
                    }
                }

                sb.append(String.format("%d %d %d\n%d\n", totalMiles, stopForGasPerMile, stopForFoodPerMile, stopCnt));
            }

            bw.write(sb.toString());
        }
    }
}
