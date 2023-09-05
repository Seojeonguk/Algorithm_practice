import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[] SCORES = {10, 8, 6, 5, 4, 3, 2, 1, 0};
    final static int TOTAL_RACER = 8;
    final static int SECOND = 60;
    final static int MILLISECOND = 1000;

    public static void main(String[] args) throws Exception {
        Racer[] racers = new Racer[TOTAL_RACER];
        for (int idx = 0; idx < TOTAL_RACER; idx++) {
            st = new StringTokenizer(br.readLine());
            String[] record = st.nextToken().split(":");
            char team = st.nextToken().charAt(0);

            int totalRecordMilliseconds = 0;
            totalRecordMilliseconds += Integer.parseInt(record[0]) * SECOND * MILLISECOND;
            totalRecordMilliseconds += Integer.parseInt(record[1]) * MILLISECOND;
            totalRecordMilliseconds += Integer.parseInt(record[2]);

            racers[idx] = new Racer(totalRecordMilliseconds, team);
        }

        Arrays.sort(racers, (o1, o2) -> {
            return Integer.compare(o1.record, o2.record);
        });

        int redTeamScore = 0, blueTeamScore = 0;
        for (int idx = 0; idx < TOTAL_RACER; idx++) {
            if (racers[idx].team == 'R') {
                redTeamScore += SCORES[idx];
            } else {
                blueTeamScore += SCORES[idx];
            }
        }
        sb.append(redTeamScore > blueTeamScore ? "Red" : "Blue");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Racer {
        int record;
        char team;

        Racer(int record, char team) {
            this.record = record;
            this.team = team;
        }
    }
}
