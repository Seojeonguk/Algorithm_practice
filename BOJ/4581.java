import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String INSUFFICIENT_PEOPLE = "need quorum";
    static final String VOTE_RESULT_YES = "yes";
    static final String VOTE_RESULT_NO = "no";
    static final String VOTE_RESULT_TIE = "tie";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] votes = br.readLine().toCharArray();
            if (votes[0] == '#') {
                break;
            }

            String voteResult = checkVotes(votes);
            sb.append(voteResult).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String checkVotes(char[] votes) {
        String voteResult = "";
        int yesVoteCnt = 0, noVoteCnt = 0, notVoteCnt = 0, absentMeeting = 0;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] == 'Y') {
                yesVoteCnt++;
            } else if (votes[i] == 'N') {
                noVoteCnt++;
            } else if (votes[i] == 'P') {
                notVoteCnt++;
            } else if (votes[i] == 'A') {
                absentMeeting++;
            }
        }

        if ((votes.length + 1) / 2 <= absentMeeting) {
            voteResult = INSUFFICIENT_PEOPLE;
        } else if (yesVoteCnt > noVoteCnt) {
            voteResult = VOTE_RESULT_YES;
        } else if (yesVoteCnt < noVoteCnt) {
            voteResult = VOTE_RESULT_NO;
        } else {
            voteResult = VOTE_RESULT_TIE;
        }

        return voteResult;
    }
}
