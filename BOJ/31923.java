import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            StringTokenizer strawberryInfo = new StringTokenizer(br.readLine());
            int[] strawberries = new int[n];
            for (int i = 0; i < n; i++) {
                strawberries[i] = Integer.parseInt(strawberryInfo.nextToken());
            }

            StringTokenizer shineMuscatInfo = new StringTokenizer(br.readLine());
            int[] shineMuscats = new int[n];
            for (int i = 0; i < n; i++) {
                shineMuscats[i] = Integer.parseInt(shineMuscatInfo.nextToken());
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if ((p > q && strawberries[i] > shineMuscats[i]) || (p < q && strawberries[i] < shineMuscats[i]) || (p == q && strawberries[i] != shineMuscats[i])) {
                    sb.append("NO");
                    break;
                }

                int diff = Math.abs(p - q);

                if (diff == 0) {
                    ans[i] = 0;
                } else {
                    int requiredDiff = Math.abs(strawberries[i] - shineMuscats[i]);

                    if (requiredDiff % diff != 0) {
                        sb.append("NO");
                        break;
                    }

                    ans[i] = requiredDiff / diff;
                }
            }

            if (sb.isEmpty()) {
                sb.append("YES\n");
                for (int i = 0; i < n; i++) {
                    sb.append(ans[i]).append(" ");
                }
            }

            bw.write(sb.toString());
        }
    }
}
