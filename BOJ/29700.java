import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int clubMemberCnt = Integer.parseInt(st.nextToken());

        int totalPossibleCase = 0;
        for (int row = 0; row < rowSize; row++) {
            String rowSeatInfo = br.readLine();
            int emptyCnt = 0;
            for (int col = 0; col < Math.min(colSize, clubMemberCnt); col++) {
                if (rowSeatInfo.charAt(col) == '0') {
                    emptyCnt++;
                }
            }
            if (emptyCnt == clubMemberCnt) {
                totalPossibleCase++;
            }

            for (int col = clubMemberCnt; col < colSize; col++) {
                emptyCnt += (rowSeatInfo.charAt(col) == '0' ? 1 : 0);
                emptyCnt -= (rowSeatInfo.charAt(col - clubMemberCnt) == '0' ? 1 : 0);
                if (emptyCnt == clubMemberCnt) {
                    totalPossibleCase++;
                }
            }
        }
        sb.append(totalPossibleCase);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
