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
            int leftCoachCnt = Integer.parseInt(st.nextToken());
            int rightCoachCnt = Integer.parseInt(st.nextToken());
            int frontCoachNum = Integer.parseInt(st.nextToken());
            int lookingForNum = Integer.parseInt(st.nextToken());

            int diff = Math.abs(frontCoachNum - lookingForNum);

            if (lookingForNum == frontCoachNum) {
                sb.append("G");
            } else if (diff <= leftCoachCnt && diff > rightCoachCnt) {
                sb.append("L");
            } else if (diff <= rightCoachCnt && diff > leftCoachCnt) {
                sb.append("R");
            } else {
                sb.append("E");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
