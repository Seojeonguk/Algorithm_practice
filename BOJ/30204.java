import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int roomCnt = Integer.parseInt(st.nextToken());
        int groupCnt = Integer.parseInt(st.nextToken());

        int totalSoldier = 0;
        st = new StringTokenizer(br.readLine());
        while (roomCnt-- > 0) {
            totalSoldier += Integer.parseInt(st.nextToken());
        }

        sb.append(totalSoldier % groupCnt == 0 ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
