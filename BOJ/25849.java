import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] DOLLARS = {1, 5, 10, 20, 50, 100};

    public static void main(String[] args) throws Exception {
        int[] bills = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int selectIdx = -1, maxSum = -1;
        for (int i = 0; i < DOLLARS.length; i++) {
            int sum = DOLLARS[i] * bills[i];
            if (sum >= maxSum) {
                selectIdx = i;
                maxSum = sum;
            }
        }

        sb.append(DOLLARS[selectIdx]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
