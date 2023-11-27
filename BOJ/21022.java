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
        int matchCnt = Integer.parseInt(br.readLine());
        int[] BINUSTeamMatches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] opportunityTeamMatches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int BINUSTeamScore = 0;
        for (int match = 0; match < matchCnt; match++) {
            if (BINUSTeamMatches[match] > opportunityTeamMatches[match]) BINUSTeamScore += 3;
            else if (BINUSTeamMatches[match] == opportunityTeamMatches[match]) BINUSTeamScore++;
        }

        sb.append(BINUSTeamScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
