import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int level = Integer.parseInt(st.nextToken());
        long eatenCnt = Long.parseLong(st.nextToken());

        long[] eatenDp = new long[level + 1];
        long[] eatenPattyDp = new long[level + 1];
        eatenDp[0] = eatenPattyDp[0] = 1;

        for (int i = 1; i <= level; i++) {
            eatenDp[i] = 2 * eatenDp[i - 1] + 3;
            eatenPattyDp[i] = 2 * eatenPattyDp[i - 1] + 1;
        }

        long eatenPattyCnt = 0;
        for (int i = level; i > 0; i--) {
            if (eatenCnt <= 1) {
                break;
            }
            if (eatenDp[i - 1] + 1 > eatenCnt) {
                eatenCnt--;
            } else if (eatenDp[i - 1] + 1 == eatenCnt) {
                eatenPattyCnt += eatenPattyDp[i - 1];
                break;
            } else if (eatenDp[i - 1] + 2 == eatenCnt) {
                eatenPattyCnt += eatenPattyDp[i - 1] + 1;
                break;
            } else if (eatenDp[i - 1] * 2 + 2 > eatenCnt) {
                eatenPattyCnt += eatenPattyDp[i - 1] + 1;
                eatenCnt = eatenCnt - eatenDp[i - 1] - 2;
            } else {
                eatenPattyCnt += eatenPattyDp[i];
                break;
            }
        }

        sb.append(eatenPattyCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
