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

            int jobCnt = Integer.parseInt(br.readLine());
            int[] jobTimes = new int[jobCnt];
            StringTokenizer times = new StringTokenizer(br.readLine());
            int[] moded = new int[7];
            for (int idx = 0; idx < jobCnt; idx++) {
                jobTimes[idx] = Integer.parseInt(times.nextToken());
                moded[jobTimes[idx] % 7]++;
            }

            sb.append(canGoHealth(moded, 0) ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }

    public static boolean canGoHealth(int[] moded, int sum) {
        if (sum % 7 == 4) {
            return true;
        }

        boolean ret = false;
        for (int i = 1; i < moded.length; i++) {
            if (moded[i] > 0) {
                moded[i]--;
                ret |= canGoHealth(moded, sum + i);
                if (ret) {
                    return true;
                }
                moded[i]++;
            }
        }

        return ret;
    }
}
