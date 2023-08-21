import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Team[] teams = new Team[2];
        teams[0] = new Team(br.readLine(), 0);
        teams[1] = new Team(br.readLine(), 0);

        int strokeCnt = Integer.parseInt(br.readLine());
        String recordedShots = br.readLine();

        for (int idx = 0; idx < strokeCnt; idx++) {
            char code = recordedShots.charAt(idx);
            if (code == 'H') {
                teams[idx % 2].addScore(1);
            } else if (code == 'D') {
                teams[idx % 2].addScore(2);
            } else if (code == 'O') {
                teams[(idx + 1) % 2].addScore(1);
            }

            if (teams[0].isFinish() || teams[1].isFinish()) {
                break;
            }
        }

        sb.append(String.format("%s %d %s %d. ", teams[0].getName(), teams[0].getScore(), teams[1].getName(), teams[1].getScore()));

        if (teams[0].getScore() > teams[1].getScore()) {
            if (teams[0].isFinish()) {
                sb.append(String.format("%s has won.", teams[0].getName()));
            } else {
                sb.append(String.format("%s is winning.", teams[0].getName()));
            }
        } else if (teams[0].getScore() < teams[1].getScore()) {
            if (teams[1].isFinish()) {
                sb.append(String.format("%s has won.", teams[1].getName()));
            } else {
                sb.append(String.format("%s is winning.", teams[1].getName()));
            }
        } else {
            sb.append("All square.");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Team {
        private String name;
        private int score;

        Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score >= 7 ? 7 : this.score;
        }

        public void addScore(int additionalScore) {
            this.score += additionalScore;
        }

        public boolean isFinish() {
            return this.score >= 7;
        }
    }
}
