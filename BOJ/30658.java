import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int teamCnt = Integer.parseInt(br.readLine());
            if (teamCnt == 0) {
                break;
            }
            int[] teams = new int[teamCnt + 1];
            for (int i = 1; i <= teamCnt; i++) {
                teams[i] = Integer.parseInt(br.readLine());
            }
            for (int i = teamCnt; i >= 0; i--) {
                sb.append(teams[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
