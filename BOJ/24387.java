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
        long[] prices = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] weights = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(prices);
        Arrays.sort(weights);

        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += prices[i] * weights[i];
        }

        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
