import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            int firstBackwardNum = reverse(Integer.parseInt(st.nextToken()));
            int secondBackwardNum = reverse(Integer.parseInt(st.nextToken()));

            int backwardSum = reverse(firstBackwardNum + secondBackwardNum);
            sb.append(backwardSum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int reverse(int x) {
        int ret = 0;
        while (x > 0) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
