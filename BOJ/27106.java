import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] CENTS = {25, 10, 5, 1};

    public static void main(String[] args) throws Exception {
        int purchase = 100 - Integer.parseInt(br.readLine());

        for (int i = 0; i < CENTS.length; i++) {
            sb.append(purchase / CENTS[i]).append(" ");
            purchase %= CENTS[i];
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
