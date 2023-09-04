import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int buttonTime = Integer.parseInt(st.nextToken());
        int waitTime = Integer.parseInt(st.nextToken());
        int[] buttons = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        int[] buttonClicks = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};

        int totalTime = 0;
        String message = br.readLine();
        int prevButton = -1, nowButton = -1;
        for (int idx = 0; idx < message.length(); idx++) {
            if (message.charAt(idx) == ' ') {
                totalTime += buttonTime;
                prevButton = -1;
                continue;
            }
            int buttonIdx = message.charAt(idx) - 'A';
            nowButton = buttons[buttonIdx];
            if (prevButton != nowButton) {
                totalTime += buttonTime * buttonClicks[buttonIdx];
            } else {
                totalTime += buttonTime * buttonClicks[buttonIdx] + waitTime;
            }
            prevButton = nowButton;
        }
        sb.append(totalTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
