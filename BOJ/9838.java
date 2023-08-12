import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int guestCnt = Integer.parseInt(br.readLine());

        int[] selectedPresentNums = new int[guestCnt + 1];

        for (int i = 1; i <= guestCnt; i++) {
            int selectedPresentNum = Integer.parseInt(br.readLine());
            selectedPresentNums[selectedPresentNum] = i;
        }
        for (int i = 1; i <= guestCnt; i++) {
            sb.append(String.format("%d\n", selectedPresentNums[i]));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
