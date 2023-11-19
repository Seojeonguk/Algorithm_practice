import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalSumStat = 0;
        for (int idx = 0; idx < 4; idx++) {
            totalSumStat += Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(st.nextToken());

        sb.append(Math.max(0, n * 4 - totalSumStat));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
