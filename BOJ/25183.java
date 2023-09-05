import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lottoLength = Integer.parseInt(br.readLine());
        String lotto = br.readLine();

        boolean isWin = false;
        for (int idx = 0; idx < lottoLength - 4; idx++) {
            int oneDiffCnt = 0;
            for (int j = idx; j < idx + 4; j++) {
                int front = lotto.charAt(j) - 'A';
                int back = lotto.charAt(j + 1) - 'A';
                oneDiffCnt += (Math.abs(back - front) == 1 ? 1 : 0);
            }
            if (oneDiffCnt == 4) {
                isWin = true;
                break;
            }
        }
        sb.append(isWin ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
