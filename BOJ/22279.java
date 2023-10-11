import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int periodCnt = Integer.parseInt(br.readLine());

        double sumQALY = 0;
        while (periodCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            double q = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            sumQALY += q * y;
        }
        sb.append(sumQALY);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
