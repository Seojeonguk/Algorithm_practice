import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int playerCnt = Integer.parseInt(st.nextToken());
        int gameCnt = Integer.parseInt(st.nextToken());

        int scoredInAllGamePlayerCnt = 0;
        for (int i = 0; i < playerCnt; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isScoredInAllGame = true;
            for (int j = 0; j < gameCnt; j++) {
                int scoredPoints = Integer.parseInt(st.nextToken());
                isScoredInAllGame &= (scoredPoints != 0);

            }
            if (isScoredInAllGame) {
                scoredInAllGamePlayerCnt++;
            }
        }
        sb.append(scoredInAllGamePlayerCnt);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
