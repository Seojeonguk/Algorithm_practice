import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int LOTTERY_MIN_NUM = 1;
    static final int LOTTERY_MAX_NUM = 50;
    static final int ANALYZE_COUNT = 10;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            int[] appearedCnt = new int[LOTTERY_MAX_NUM + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < ANALYZE_COUNT; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while (st.hasMoreElements()) {
                        int appeared = Integer.parseInt(st.nextToken());
                        appearedCnt[appeared]++;
                    }
                }
            }

            for (int i = LOTTERY_MIN_NUM; i <= LOTTERY_MAX_NUM; i++) {
                if (appearedCnt[i] > 2 * n) {
                    sb.append(i).append(" ");
                }
            }

            if (sb.isEmpty()) {
                sb.append(-1);
            }

            bw.write(sb.toString());
        }
    }
}
