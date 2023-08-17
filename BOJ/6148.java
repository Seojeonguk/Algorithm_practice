import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_HEIGHT = 1000000 * 20;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cowCnt = Integer.parseInt(st.nextToken());
        int bookshelfHeight = Integer.parseInt(st.nextToken());

        int[] cows = new int[cowCnt];
        boolean[] isSelected = new boolean[cowCnt];
        for (int i = 0; i < cowCnt; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int minimalExcessHeight = setCows(cows, bookshelfHeight, isSelected, 0, -1);
        sb.append(minimalExcessHeight - bookshelfHeight);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int setCows(int[] cows, int bookshelfHeight, boolean[] isSelected, int stackHeight, int selectedIdx) {
        if (stackHeight >= bookshelfHeight) {
            return stackHeight;
        }
        int optimalHeight = MAX_HEIGHT;
        for (int idx = selectedIdx + 1; idx < cows.length; idx++) {
            if (isSelected[idx]) {
                continue;
            }
            int nextStackHeight = stackHeight + cows[idx];
            boolean[] nextIsSelected = isSelected.clone();
            nextIsSelected[idx] = true;
            optimalHeight = Math.min(optimalHeight, setCows(cows, bookshelfHeight, nextIsSelected, nextStackHeight, idx));
        }
        return optimalHeight;
    }
}
