import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int money = getMoney(d, p, q);
        sb.append(money);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMoney(int d, int p, int q) {
        if (d % p == 0 || d % q == 0) {
            return d;
        }

        int ans = Integer.MAX_VALUE;
        for (int pCnt = 0; pCnt < q; pCnt++) {
            int pMoney = p * pCnt;
            int restMoney = Math.max(d - pMoney, 0);
            int qCnt = restMoney / q + (restMoney % q != 0 ? 1 : 0);
            int takeMoney = pMoney + qCnt * q;

            if (takeMoney >= d) {
                ans = Math.min(ans, takeMoney);
            }
            if (pMoney > d || ans == d) {
                break;
            }
        }
        return ans;
    }
}
