import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int TECHNIC_CNT = 3;
    final static int CLUB_PER_PERSON_CNT = 3;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int[] technicalScores = new int[TECHNIC_CNT];
        for (int idx = 0; idx < TECHNIC_CNT; idx++) {
            technicalScores[idx] = Integer.parseInt(st.nextToken());
        }
        int clubCnt = Integer.parseInt(br.readLine());
        int[] clubScores = new int[clubCnt];
        for (int club = 0; club < clubCnt; club++) {
            int clubScore = 0;
            for (int memberNum = 0; memberNum < CLUB_PER_PERSON_CNT; memberNum++) {
                st = new StringTokenizer(br.readLine());
                for (int technicNum = 0; technicNum < TECHNIC_CNT; technicNum++) {
                    int usedCnt = Integer.parseInt(st.nextToken());
                    clubScore += usedCnt * technicalScores[technicNum];
                }
            }
            clubScores[club] = clubScore;
        }

        int maxScore = Arrays.stream(clubScores).max().getAsInt();
        sb.append(maxScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
