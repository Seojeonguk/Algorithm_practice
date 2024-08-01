import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int totalStudent = Integer.parseInt(br.readLine());
            int[] studentHeights = new int[totalStudent];
            StringTokenizer heights = new StringTokenizer(br.readLine());
            for (int i = 0; i < totalStudent; i++) {
                studentHeights[i] = Integer.parseInt(heights.nextToken());
            }

            Arrays.sort(studentHeights);

            long ans = 0;
            long multiple = 1;
            for (int i = 0; i < totalStudent; i++) {
                ans = (ans + studentHeights[i] * multiple) % MOD;
                multiple = (multiple * 2) % MOD;
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
