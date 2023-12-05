import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreElements()) {
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    sb.append(" ");
                }
                if (i != n - 1) {
                    sb.append("*");
                }
                for (int j = 0; j < (n - i - 2) * 2 + 1; j++) {
                    sb.append(" ");
                }
                sb.append("*\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
