import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append((length >= a && height * 2 >= b) || (length >= b && height * 2 >= a) ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
