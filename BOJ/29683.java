import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int checkCnt = Integer.parseInt(st.nextToken());
        int ruble = Integer.parseInt(st.nextToken());

        int requiredTotalTicket = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < checkCnt; i++) {
            int cost = Integer.parseInt(st.nextToken());
            requiredTotalTicket += cost / ruble;
        }
        sb.append(requiredTotalTicket);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
