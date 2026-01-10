import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] foundIdx = new int[n + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (foundIdx[x][0] != 0) {
                foundIdx[x][1] = i + 1;
            } else {
                foundIdx[x][0] = i + 1;
            }
        }

        int maxDiff = 0;
        for (int i = 1; i <= n; i++) {
            maxDiff = Math.max(maxDiff, foundIdx[i][1] - foundIdx[i][0] - 1);
        }

        sb.append(maxDiff);

        bw.write(sb.toString());
        bw.flush();
    }
}
