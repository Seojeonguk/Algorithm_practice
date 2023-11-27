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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rotationCnt = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sn = 0, sm = 0, ln = n - 1, lm = m - 1;
        while (sn < ln && sm < lm) {
            rotation(arr, sn++, sm++, ln--, lm--, rotationCnt);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rotation(int[][] arr, int sn, int sm, int ln, int lm, int rotationCnt) {
        int mod = (ln - sn) * 2 + (lm - sm) * 2;
        int realRotationCnt = rotationCnt % mod;

        while (realRotationCnt-- > 0) {
            int tmp = arr[sn][sm];
            for (int i = sm; i < lm; i++) arr[sn][i] = arr[sn][i + 1];
            for (int i = sn; i < ln; i++) arr[i][lm] = arr[i + 1][lm];
            for (int i = lm; i > sm; i--) arr[ln][i] = arr[ln][i - 1];
            for (int i = ln; i > sn; i--) arr[i][sm] = arr[i - 1][sm];
            arr[sn + 1][sm] = tmp;
        }
    }
}
