import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX_HEIGHT = 1000000;

    public static void main(String[] args) throws Exception {
        int balloonCnt = Integer.parseInt(br.readLine());

        int[] prevArrowHeights = new int[MAX_HEIGHT + 2];
        int requiredMinimumArrow = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < balloonCnt; i++) {
            int balloonHeight = Integer.parseInt(st.nextToken());
            if (prevArrowHeights[balloonHeight + 1] > 0) {
                prevArrowHeights[balloonHeight + 1]--;
            } else {
                requiredMinimumArrow++;
            }
            prevArrowHeights[balloonHeight]++;
        }

        sb.append(requiredMinimumArrow);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
