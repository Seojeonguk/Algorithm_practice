import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oneRuble = Integer.parseInt(st.nextToken());
            int twoRuble = Integer.parseInt(st.nextToken());
            int bicycleCost = Integer.parseInt(st.nextToken());

            int maxTwoRuble = Math.min(bicycleCost / 2, twoRuble);
            int anotherOneCost = bicycleCost - maxTwoRuble * 2;

            sb.append(anotherOneCost <= oneRuble ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
