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
        int d = Integer.parseInt(st.nextToken());

        int frequency = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x > 0) {
                int digit = x % 10;
                if (digit == d) {
                    frequency++;
                }
                x /= 10;
            }
        }
        sb.append(frequency);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
