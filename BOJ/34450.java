import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int startNum = Integer.parseInt(br.readLine());

        int[] appearedNums = new int[n];
        appearedNums[n - 1] = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            appearedNums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(appearedNums);

        for (int i = 0; i < n; i++) {
            if (appearedNums[i] != startNum + i) {
                sb.append(startNum + i);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
