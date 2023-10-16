import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int observedCnt = Integer.parseInt(br.readLine());
        int[] prevCowPlace = new int[11];
        Arrays.fill(prevCowPlace, -1);

        int cowCrossCnt = 0;
        while (observedCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int cowPlace = Integer.parseInt(st.nextToken());

            if (prevCowPlace[cowNum] != -1 && prevCowPlace[cowNum] != cowPlace) {
                cowCrossCnt++;
            }
            prevCowPlace[cowNum] = cowPlace;
        }
        sb.append(cowCrossCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
