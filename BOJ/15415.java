import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cakeWidth = Integer.parseInt(br.readLine());
        int shatteredCnt = Integer.parseInt(br.readLine());

        int sumShatteredSize = 0;
        for (int i = 0; i < shatteredCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            sumShatteredSize += width * length;
        }
        sb.append(sumShatteredSize / cakeWidth);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
