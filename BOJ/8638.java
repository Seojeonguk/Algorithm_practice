import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalPlayer = Integer.parseInt(br.readLine());
        int[] rounds = new int[totalPlayer];
        StringTokenizer playerInfo = new StringTokenizer(br.readLine());

        int maxScore = 0;
        for (int idx = 0; idx < totalPlayer; idx++) {
            rounds[idx] = Integer.parseInt(playerInfo.nextToken());
            maxScore = Math.max(maxScore, rounds[idx]);
        }

        for (int idx = 0; idx < totalPlayer; idx++) {
            if (rounds[idx] == maxScore) {
                sb.append((char) ('A' + idx));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
