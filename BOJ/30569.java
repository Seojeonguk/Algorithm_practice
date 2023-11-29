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

    public static void main(String[] args) throws Exception {
        int[][] unitInfo = new int[2][3];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                unitInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minFirstTimeToWin = getMinTimeToWin(unitInfo, 0);
        int minSecondTimeToWin = getMinTimeToWin(unitInfo, 1);

        if (minFirstTimeToWin < minSecondTimeToWin) {
            sb.append("player one");
        } else if (minSecondTimeToWin < minFirstTimeToWin) {
            sb.append("player two");
        } else {
            sb.append("draw");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMinTimeToWin(int[][] unitInfo, int winPlayer) {
        int opponentPlayer = 1 - winPlayer;
        int remainHealth = unitInfo[opponentPlayer][0] - unitInfo[winPlayer][1];

        int reloadCnt = remainHealth / unitInfo[winPlayer][1] + (remainHealth % unitInfo[winPlayer][1] > 0 ? 1 : 0);
        int reloadTime = reloadCnt * unitInfo[winPlayer][2];

        return reloadTime;
    }
}
