import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] prefixSums = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            int breedId = Integer.parseInt(br.readLine());
            for (int j = 1; j <= 3; j++) {
                prefixSums[i][j] = prefixSums[i - 1][j];
            }
            prefixSums[i][breedId]++;
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(prefixSums[r][1] - prefixSums[l - 1][1]).append(" ")
                    .append(prefixSums[r][2] - prefixSums[l - 1][2]).append(" ")
                    .append(prefixSums[r][3] - prefixSums[l - 1][3]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
