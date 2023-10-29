import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int measurementCnt = Integer.parseInt(br.readLine());

        int maxOffLineTime = 0;
        int prevOnTime = 1;

        while (measurementCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int isOn = Integer.parseInt(st.nextToken());

            if (isOn == 1) {
                maxOffLineTime = Math.max(maxOffLineTime, time - prevOnTime);
                prevOnTime = time;
            }
        }

        sb.append(maxOffLineTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
