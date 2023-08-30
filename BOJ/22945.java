import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int developerCnt = Integer.parseInt(br.readLine());
        int[] stats = new int[developerCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < developerCnt; idx++) {
            stats[idx] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = developerCnt - 1;
        int maxTeamStat = 0;
        while (left < right) {
            int minStat = Math.min(stats[left], stats[right]);
            maxTeamStat = Math.max(maxTeamStat, minStat * (right - left - 1));
            if (stats[left] == minStat) {
                left++;
            }
            if (stats[right] == minStat) {
                right--;
            }
        }
        sb.append(maxTeamStat);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
