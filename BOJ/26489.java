import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void  main(String[] args) throws Exception {
        int ans=0;
        while("gum gum for jay jay".equals(br.readLine())) {
            ans++;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}