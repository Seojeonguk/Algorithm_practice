import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int pressedCnt = Integer.parseInt(br.readLine());
        int[] pressedTimes = new int[pressedCnt];

        int displayTime = 0;
        for (int i = 0; i < pressedCnt; i++) {
            int pressedTime = Integer.parseInt(br.readLine());
            pressedTimes[i] = pressedTime;
            if (i % 2 == 1) {
                displayTime += pressedTimes[i] - pressedTimes[i - 1];
            }
        }
        sb.append(pressedCnt % 2 == 1 ? "still running" : displayTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
