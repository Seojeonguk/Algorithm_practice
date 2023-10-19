import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int playerCnt = Integer.parseInt(br.readLine());

        int starRatingPlayerCnt = 0;
        for (int player = 0; player < playerCnt; player++) {
            int playerScore = Integer.parseInt(br.readLine());
            int playerFour = Integer.parseInt(br.readLine());

            int playerStart = playerScore * 5 - playerFour * 3;
            if (playerStart > 40) {
                starRatingPlayerCnt++;
            }
        }
        sb.append(starRatingPlayerCnt);
        if (starRatingPlayerCnt == playerCnt) {
            sb.append("+");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
