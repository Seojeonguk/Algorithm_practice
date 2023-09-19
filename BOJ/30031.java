import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static Map<Integer, Integer> bills = Map.of(
            136, 1000,
            142, 5000,
            148, 10000,
            154, 50000
    );

    public static void main(String[] args) throws Exception {
        int billCnt = Integer.parseInt(br.readLine());

        int totalMoney = 0;
        for (int bill = 0; bill < billCnt; bill++) {
            st = new StringTokenizer(br.readLine());
            int billWidth = Integer.parseInt(st.nextToken());
            int billHeight = Integer.parseInt(st.nextToken());

            totalMoney += bills.get(billWidth);
        }
        sb.append(totalMoney);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
