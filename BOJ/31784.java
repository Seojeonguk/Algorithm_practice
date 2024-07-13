import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int lockLength = Integer.parseInt(st.nextToken());
            int workCnt = Integer.parseInt(st.nextToken());

            char[] locks = br.readLine().toCharArray();
            for (int idx = 0; idx < lockLength - 1; idx++) {
                int aCnt = 'Z' - locks[idx] + 1;

                if (locks[idx] == 'A' || aCnt > workCnt) {
                    sb.append(locks[idx]);
                } else {
                    sb.append('A');
                    workCnt -= aCnt;
                }
            }

            sb.append((char) ((locks[lockLength - 1] - 'A' + workCnt) % 26 + 'A'));

            bw.write(sb.toString());
        }
    }
}
