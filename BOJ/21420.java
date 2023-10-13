import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int coinCnt = Integer.parseInt(br.readLine());

        int upCoinCnt = 0;
        for (int i = 0; i < coinCnt; i++) {
            int coinStatus = Integer.parseInt(br.readLine());
            if (coinStatus == 0) {
                upCoinCnt++;
            }
        }
        sb.append(Math.min(upCoinCnt, coinCnt - upCoinCnt));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
