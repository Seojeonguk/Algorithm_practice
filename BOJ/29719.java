import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long day = Long.parseLong(st.nextToken());
        long people = Long.parseLong(st.nextToken());

        long totalCase = 1;
        long exceptionCase = 1;
        for (int i = 0; i < day; i++) {
            totalCase = (totalCase * people) % MOD;
            exceptionCase = (exceptionCase * (people - 1)) % MOD;
        }
        sb.append((totalCase - exceptionCase + MOD) % MOD);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
