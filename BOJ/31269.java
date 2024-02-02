import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalParticipant = Integer.parseInt(br.readLine());
        Participant[] participants = new Participant[totalParticipant];
        for (int i = 0; i < totalParticipant; i++) {
            participants[i] = new Participant(i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int rank = 0; rank < totalParticipant; rank++) {
            int participantNum = Integer.parseInt(st.nextToken());
            participants[participantNum - 1].setPresidentScore(totalParticipant - rank);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalParticipant; i++) {
            int associationVote = Integer.parseInt(st.nextToken());
            participants[i].setAssociationVote(associationVote);
        }

        Arrays.sort(participants, Comparator.comparing(Participant::getAssociationVote));
        for (int i = 0; i < totalParticipant; i++) {
            participants[i].setAssociationScore(i + 1);
        }

        Arrays.sort(participants, (o1, o2) -> {
            int leftSum = o1.getSumPoints();
            int rightSum = o2.getSumPoints();
            if (leftSum == rightSum) {
                return Integer.compare(o2.associationScore, o1.associationScore);
            }
            return Integer.compare(rightSum, leftSum);
        });

        for (int i = 0; i < totalParticipant; i++) {
            sb.append(String.format("%d. Kod%02d (%d)\n", i + 1, participants[i].num, participants[i].getSumPoints()));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Participant {
        int num;
        int associationVote;
        int presidentScore;
        int associationScore;

        Participant(int num) {
            this.num = num;
            this.associationVote = 0;
            this.presidentScore = 0;
            this.associationScore = 0;
        }

        public int getAssociationVote() {
            return associationVote;
        }

        public void setAssociationVote(int associationVote) {
            this.associationVote = associationVote;
        }

        public void setPresidentScore(int presidentScore) {
            this.presidentScore = presidentScore;
        }

        public void setAssociationScore(int associationScore) {
            this.associationScore = associationScore;
        }

        public int getSumPoints() {
            return this.presidentScore + this.associationScore;
        }
    }
}
