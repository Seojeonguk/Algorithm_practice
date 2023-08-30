import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int arraySize = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[arraySize];
        for (int idx = 0; idx < arraySize; idx++) {
            array[idx] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[arraySize];
        int maxTotal = 0;
        for (int i = 0; i < arraySize; i++) {
            dp[i] = array[i];
            for (int j = 0; j < i; j++) {
                if (array[i] >= array[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + array[i]);
            }
            maxTotal = Math.max(maxTotal, dp[i]);
        }
        sb.append(maxTotal);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
