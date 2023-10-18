import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int strawCnt = Integer.parseInt(br.readLine());
        int[] straws = new int[strawCnt];
        for (int idx = 0; idx < strawCnt; idx++) {
            straws[idx] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straws);

        int maxTriangle = -1;
        for (int idx = 0; idx < strawCnt - 2; idx++) {
            int sumTriangle = straws[idx] + straws[idx + 1] + straws[idx + 2];
            if (straws[idx] + straws[idx + 1] > straws[idx + 2]) {
                maxTriangle = Math.max(maxTriangle, sumTriangle);
            }
        }
        sb.append(maxTriangle);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
