import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long minimumCrystal = (b + 1) * (2 + b * (a - 2)) / 2;
        sb.append(minimumCrystal);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
