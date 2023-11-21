import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int zebraCnt = Integer.parseInt(st.nextToken());
        int zebraLength = Integer.parseInt(st.nextToken());

        int maxBeautifulZebraHasBlack = 0;
        int maxBeautifulZebraCnt = 0;
        while (zebraCnt-- > 0) {
            String zebraState = br.readLine();

            int zebraHasBlack = (zebraState.charAt(0) == '1' ? 1 : 0);
            for (int zebraIdx = 1; zebraIdx < zebraLength; zebraIdx++) {
                if (zebraState.charAt(zebraIdx) == '1' && zebraState.charAt(zebraIdx - 1) == '0') {
                    zebraHasBlack++;
                }
            }

            if (maxBeautifulZebraHasBlack < zebraHasBlack) {
                maxBeautifulZebraHasBlack = zebraHasBlack;
                maxBeautifulZebraCnt = 1;
            } else if (maxBeautifulZebraHasBlack == zebraHasBlack) {
                maxBeautifulZebraCnt++;
            }
        }

        sb.append(maxBeautifulZebraHasBlack).append(" ").append(maxBeautifulZebraCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
