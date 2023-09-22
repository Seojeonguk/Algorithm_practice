import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        isPrime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        char first = 'S', last = 'B';
        int bCnt = 0, sCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                bCnt++;
                last = 'B';
            } else {
                if (last == 'B') {
                    bCnt--;
                    sCnt++;
                }
                sCnt++;
                last = first;
                first = 'S';
            }
        }
        sb.append(String.format("%d %d\n", bCnt, sCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
