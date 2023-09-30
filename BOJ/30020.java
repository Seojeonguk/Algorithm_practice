import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int pattie = Integer.parseInt(st.nextToken());
        int cheese = Integer.parseInt(st.nextToken());

        if (cheese + 1 > pattie || cheese * 2 < pattie) {
            sb.append("NO");
        } else {
            sb.append("YES").append("\n");
            int burgerCnt = pattie - cheese;
            sb.append(burgerCnt).append("\n");
            pattie -= burgerCnt * 2;
            String initBurger = "aba";
            for (int idx = 0; idx < pattie; idx++) {
                sb.append("ab");
            }
            for (int i = 0; i < burgerCnt; i++) {
                sb.append(initBurger).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
