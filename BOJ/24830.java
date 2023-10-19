import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int commandCnt = Integer.parseInt(br.readLine());

        long prevResult = 1;
        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            char c = st.nextToken().charAt(0);
            long b = Long.parseLong(st.nextToken());

            long result = 0;

            if (c == '+') {
                result = a + b - prevResult;
            } else if (c == '-') {
                result = (a - b) * prevResult;
            } else if (c == '*') {
                result = a * a * b * b;
            } else if (c == '/') {
                result = (a + 1) / 2;
            }
            sb.append(result).append("\n");
            prevResult = result;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
