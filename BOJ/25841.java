import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int findDigit = Integer.parseInt(st.nextToken());

        int appearedDigitCnt = 0;
        for (int i = start; i <= end; i++) {
            int temp = i;
            while (temp > 0) {
                appearedDigitCnt += (temp % 10 == findDigit ? 1 : 0);
                temp /= 10;
            }
        }
        sb.append(appearedDigitCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
