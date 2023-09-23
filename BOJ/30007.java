import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cookRamenCnt = Integer.parseInt(br.readLine());

        while (cookRamenCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int water = Integer.parseInt(st.nextToken());
            int ramenCoefficient = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            sb.append(water * (ramen - 1) + ramenCoefficient).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
