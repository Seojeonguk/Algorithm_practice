import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        double time = Double.parseDouble(st.nextToken());
        double maxDiff = Double.parseDouble(st.nextToken());
        double velocityAverage = Double.parseDouble(st.nextToken());

        sb.append(Math.max(0, velocityAverage - 2 * maxDiff / time));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
