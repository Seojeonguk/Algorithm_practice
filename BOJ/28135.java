import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int containedCnt = 0;
        for (int i = 1; i < n; i++) {
            String str = String.valueOf(i);
            if (str.contains("50")) {
                containedCnt++;
            }
        }
        sb.append(n + containedCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
