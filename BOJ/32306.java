import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int TOTAL_TEAM = 2;
    static final int[] SHOT_POINTERS = {1, 2, 3};

    static final int RESULT_TIE = 0;
    static final int RESULT_A_TEAM_WIN = 1;
    static final int RESULT_B_TEAM_WIN = 2;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[] scores = new int[TOTAL_TEAM];

            for (int i = 0; i < TOTAL_TEAM; i++) {
                int[] points = new int[SHOT_POINTERS.length];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < SHOT_POINTERS.length; j++) {
                    points[j] = Integer.parseInt(st.nextToken());
                }

                scores[i] = calScore(points);
            }

            if (scores[0] < scores[1]) {
                sb.append(RESULT_B_TEAM_WIN);
            } else if (scores[0] > scores[1]) {
                sb.append(RESULT_A_TEAM_WIN);
            } else {
                sb.append(RESULT_TIE);
            }

            bw.write(sb.toString());
        }
    }

    public static int calScore(int[] points) {
        int score = 0;

        for (int idx = 0; idx < points.length; idx++) {
            score += points[idx] * SHOT_POINTERS[idx];
        }

        return score;
    }
}
