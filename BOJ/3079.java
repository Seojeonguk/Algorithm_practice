import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int immigrationCnt = Integer.parseInt(st.nextToken());
        long friendsCnt = Integer.parseInt(st.nextToken());

        long[] immigrations = new long[immigrationCnt];
        for (int immigration = 0; immigration < immigrationCnt; immigration++) {
            immigrations[immigration] = Long.parseLong(br.readLine());
        }
        Arrays.sort(immigrations);

        long left = immigrations[0];
        long right = immigrations[immigrationCnt - 1] * friendsCnt;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int immigration = 0; immigration < immigrationCnt; immigration++) {
                cnt += mid / immigrations[immigration];
                if (cnt >= friendsCnt) {
                    break;
                }
            }
            if (cnt >= friendsCnt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        sb.append(left);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
