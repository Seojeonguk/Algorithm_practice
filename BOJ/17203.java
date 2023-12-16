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
        st = new StringTokenizer(br.readLine());
        int singLength = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());
        int[] singSpeeds = new int[singLength + 1];
        int[] prefixSums = new int[singLength + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= singLength; i++) {
            singSpeeds[i] = Integer.parseInt(st.nextToken());
            prefixSums[i] = prefixSums[i - 1] + Math.abs(singSpeeds[i] - singSpeeds[i - 1]);
        }

        while (queryCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(prefixSums[r] - prefixSums[l]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
