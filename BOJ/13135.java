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
        int n = Integer.parseInt(br.readLine());

        int[][] votes = new int[n][2];

        TreeSet<Integer> a = new TreeSet<>(Arrays.asList(0,100000));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(0,100000));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                votes[i][j] = Integer.parseInt(st.nextToken());
            }
            int max = Math.max(votes[i][0], votes[i][1]);
            int sum = votes[i][0] + votes[i][1];
            a.add(max);
            b.add(sum);
        }

        int[] xIdx = new int[100001];
        int[] yIdx = new int[100001];
        int[][] dp = new int[a.size()][b.size()];
        ArrayList<Integer> x = new ArrayList<>(a);
        ArrayList<Integer> y = new ArrayList<>(b);
        for (int idx = 0; idx < x.size(); idx++) {
            xIdx[x.get(idx)] = idx;
        }
        for (int idx = 0; idx < y.size(); idx++) {
            yIdx[y.get(idx)] = idx;
        }

        for (int i = 0; i < n; i++) {
            int max = Math.max(votes[i][0], votes[i][1]);
            int sum = votes[i][0] + votes[i][1];
            dp[xIdx[max]][yIdx[sum]] = votes[i][0] - votes[i][1];
        }

        long ans = 0;
        for (int i = 1; i < a.size() - 1; i++) {
            for (int j = 1; j < b.size() - 1; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                if (dp[i][j] > 0) {
                    ans += (long) (x.get(i + 1) - x.get(i)) * (y.get(j + 1) - y.get(j));
                }
            }
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
