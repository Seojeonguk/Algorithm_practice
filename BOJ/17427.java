import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());

        long ans = 0;
        for (long i = 1; i <= n; i++) {
            ans += (n / i) * i;
        }
        sb.append(ans);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
