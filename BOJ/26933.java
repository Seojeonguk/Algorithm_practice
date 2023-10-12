import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int materialCnt = Integer.parseInt(br.readLine());

        int totalCost = 0;
        while (materialCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int required = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            totalCost += Math.max(0, required - current) * cost;
        }
        sb.append(totalCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
