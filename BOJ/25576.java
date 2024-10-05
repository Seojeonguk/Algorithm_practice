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
            int streamerCnt = Integer.parseInt(st.nextToken());
            int changedLength = Integer.parseInt(st.nextToken());

            int[][] changedStreamers = new int[streamerCnt][changedLength];
            for (int i = 0; i < streamerCnt; i++) {
                StringTokenizer changed = new StringTokenizer(br.readLine());
                for (int j = 0; j < changedLength; j++) {
                    changedStreamers[i][j] = Integer.parseInt(changed.nextToken());
                }
            }

            int badStreamCnt = 0;
            for (int i = 1; i < streamerCnt; i++) {
                int changedDiff = 0;
                for (int j = 0; j < changedLength; j++) {
                    changedDiff += Math.abs(changedStreamers[0][j] - changedStreamers[i][j]);
                }

                if (changedDiff > 2000) {
                    badStreamCnt++;
                }
            }

            sb.append(streamerCnt / 2 <= badStreamCnt ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }
}
