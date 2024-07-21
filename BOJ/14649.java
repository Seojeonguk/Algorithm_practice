import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int ROCK_CNT = 100;
    static final int ROCK_COLOR_CNT = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int property = Integer.parseInt(br.readLine());
            int secretaryCnt = Integer.parseInt(br.readLine());

            int[] rockStatus = new int[ROCK_CNT + 1];

            for (int i = 0; i < secretaryCnt; i++) {
                StringTokenizer secretaryInfo = new StringTokenizer(br.readLine());
                int place = Integer.parseInt(secretaryInfo.nextToken());
                char direction = secretaryInfo.nextToken().charAt(0);

                int dir = (direction == 'R' ? 1 : -1);
                for (int idx = place + dir; 0 < idx && idx <= ROCK_CNT; idx += dir) {
                    rockStatus[idx] = (rockStatus[idx] + 1) % ROCK_COLOR_CNT;
                }
            }

            int[] rocks = new int[ROCK_COLOR_CNT];
            for (int idx = 1; idx <= ROCK_CNT; idx++) {
                rocks[rockStatus[idx]]++;
            }

            for (int i = 0; i < 3; i++) {
                double ans = (property * rocks[i]) / 100.0;

                sb.append(String.format("%.2f", ans)).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
