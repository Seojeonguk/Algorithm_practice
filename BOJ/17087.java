import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int subinPlace = Integer.parseInt(st.nextToken());

        int possibleD = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int sisterPlace = Integer.parseInt(st.nextToken());
            int diff = Math.abs(subinPlace - sisterPlace);
            possibleD = (i == 0 ? diff : gcd(possibleD, diff));
        }
        sb.append(possibleD);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
