import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int dayAfterBirthday = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());
        long[] changedMoneys = new long[dayAfterBirthday + 1];
        for (int query = 0; query < queryCnt; query++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if (command == 1) {
                changedMoneys[p] += (long) q;
            } else {
                long changedMoney = 0;
                for (int i = p; i <= q; i++) {
                    changedMoney += changedMoneys[i];
                }
                sb.append(changedMoney).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
