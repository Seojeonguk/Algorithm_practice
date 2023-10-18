import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tradeCnt = Integer.parseInt(br.readLine());
        int minMoney = Integer.MAX_VALUE;
        int currentMoney = 0;
        while (tradeCnt-- > 0) {
            int money = Integer.parseInt(br.readLine());
            currentMoney += money;
            minMoney = Math.min(minMoney, currentMoney);
        }

        sb.append(Math.max(0, -minMoney));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
