import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int oldMachineMax = Integer.parseInt(st.nextToken());
            int newMachineMax = Integer.parseInt(st.nextToken());
            int lessThanK = Integer.parseInt(st.nextToken());

            int catalinaWinCnt = 0;
            for (int i = 0; i < oldMachineMax; i++) {
                for (int j = 0; j < newMachineMax; j++) {
                    int bitwiseAndResult = i & j;
                    if (bitwiseAndResult < lessThanK) {
                        catalinaWinCnt++;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", tc + 1, catalinaWinCnt));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
