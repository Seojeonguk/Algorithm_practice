import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MOD = 1000000009;

    public static void main(String[] args) throws Exception {
        String carNumType = br.readLine();
        char frontCarNumType = 0;
        long carNumCnt = 0;
        if (!carNumType.isEmpty()) {
            carNumCnt = 1;
        }
        for (int idx = 0; idx < carNumType.length(); idx++) {
            char nowCarNumType = carNumType.charAt(idx);
            if (frontCarNumType != nowCarNumType) {
                carNumCnt = (carNumCnt * (nowCarNumType == 'd' ? 10 : 26)) % MOD;
            } else {
                carNumCnt = (carNumCnt * (nowCarNumType == 'd' ? 9 : 25)) % MOD;
            }
            frontCarNumType = nowCarNumType;
        }
        sb.append(carNumCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
