import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int measurementTime = Integer.parseInt(br.readLine());
        char[] measurementSounds = br.readLine().toCharArray();
        boolean[] isCrying = new boolean[measurementTime];

        int minCnt = Integer.MAX_VALUE;
        for (int cycle = 1; cycle < measurementTime; cycle++) {
            Arrays.fill(isCrying, false);
            int cnt = 0;
            for (int idx = 0; idx < measurementTime; idx++) {
                if (measurementSounds[idx] == '#' && !isCrying[idx]) {
                    cnt++;
                    for (int cryingIdx = idx; cryingIdx < measurementTime; cryingIdx += cycle) {
                        if (measurementSounds[cryingIdx] == '.') {
                            break;
                        }
                        isCrying[cryingIdx] = true;
                    }
                }
            }
            minCnt = Math.min(minCnt, cnt);
        }
        sb.append(minCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
