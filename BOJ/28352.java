import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, weeks = 6;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 11; i <= n; i++) {
            weeks = weeks * i;
        }
        sb.append(weeks);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
