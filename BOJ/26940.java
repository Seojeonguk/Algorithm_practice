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

    public static void main(String[] args) throws Exception {
        int observeCnt = Integer.parseInt(br.readLine());

        int[] chocolates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int buyingCnt = 0;
        for (int i = 0; i < chocolates.length - 1; i++) {
            if (chocolates[i] < chocolates[i + 1]) {
                buyingCnt++;
            }
        }

        sb.append(buyingCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
