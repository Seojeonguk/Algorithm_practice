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

            int stationCnt = Integer.parseInt(br.readLine());
            int surfaceSum = 0;
            int platformSum = 0;

            for (int i = 0; i < stationCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int surfaceHeight = Integer.parseInt(st.nextToken());
                int platformHeight = Integer.parseInt(st.nextToken());

                surfaceSum += surfaceHeight;
                platformSum += platformHeight;

                sb.append(surfaceSum - platformSum).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
