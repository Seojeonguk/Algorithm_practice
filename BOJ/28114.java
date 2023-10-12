import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int TEAM_CNT = 3;

    public static void main(String[] args) throws Exception {
        Team[] teams = new Team[TEAM_CNT];
        for (int i = 0; i < TEAM_CNT; i++) {
            st = new StringTokenizer(br.readLine());
            int solvedProblemCnt = Integer.parseInt(st.nextToken());
            int admissionYear = Integer.parseInt(st.nextToken());
            String firstName = st.nextToken();

            teams[i] = new Team(solvedProblemCnt, admissionYear, firstName);
        }

        Arrays.sort(teams, Comparator.comparingInt(Team::getAdmissionYear));
        for (int i = 0; i < TEAM_CNT; i++) {
            sb.append(teams[i].admissionYear % 100);
        }
        sb.append("\n");

        Arrays.sort(teams, Comparator.comparing(Team::getSolvedProblemCnt).reversed());
        for (int i = 0; i < TEAM_CNT; i++) {
            sb.append(teams[i].firstName.charAt(0));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Team {
        int solvedProblemCnt;
        int admissionYear;
        String firstName;

        Team(int solvedProblemCnt, int admissionYear, String firstName) {
            this.solvedProblemCnt = solvedProblemCnt;
            this.admissionYear = admissionYear;
            this.firstName = firstName;
        }

        public int getSolvedProblemCnt() {
            return solvedProblemCnt;
        }

        public int getAdmissionYear() {
            return admissionYear % 100;
        }
    }
}
