import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            diff += (num % 2 == 0 ? -1 : 1);
        }
        sb.append((n % 2 == 0 && diff == 0) || (n % 2 == 1 && diff == 1) ? "1" : "0");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
