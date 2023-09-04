import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int leftCnt = 0, rightCnt = 0, sum = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);
            if (c == '(') {
                leftCnt++;
                sum++;
            } else if (c == ')') {
                rightCnt++;
                sum--;
            }
            if (sum < 0) {
                break;
            }
            if (sum == 0) {
                leftCnt = 0;
            }
        }
        sb.append(sum < 0 ? rightCnt : leftCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
