import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxIncreasingLength = 0;
        for (int i = 0; i < n; i++) {
            int increasingLength = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j - 1] >= arr[j]) {
                    break;
                }
                increasingLength++;
            }
            maxIncreasingLength = Math.max(maxIncreasingLength, increasingLength);
        }

        sb.append(maxIncreasingLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
