import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int strLength = Integer.parseInt(br.readLine());
            String str = br.readLine();
            sb.append(String.format("Case #%d: ", tc + 1));
            for (int endIdx = 0; endIdx < strLength; endIdx++) {
                int strictlyIncreasingSubstringLength = 1;
                for (int nowIdx = endIdx - 1; nowIdx >= 0; nowIdx--) {
                    if (str.charAt(nowIdx) >= str.charAt(nowIdx + 1)) {
                        break;
                    }
                    strictlyIncreasingSubstringLength++;
                }
                sb.append(strictlyIncreasingSubstringLength).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
