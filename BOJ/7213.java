import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[][] result = new int[2][3];
            int[][] clone = new int[2][3];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                    clone[i][j] = result[i][j];
                }
            }

            sb.append(getMaxScore(result)).append("\n").append(getMinScore(clone));

            bw.write(sb.toString());
        }
    }

    public static int getMaxScore(int[][] result) {
        int score = 0;

        for (int i = 0; i < 3; i++) {
            int min = Math.min(result[0][i], result[1][(i + 2) % 3]);
            score += min;
            result[0][i] -= min;
            result[1][(i + 2) % 3] -= min;
        }

        for (int i = 0; i < 3; i++) {
            int min = Math.min(result[0][i], result[1][(i + 1) % 3]);
            score -= min;
        }

        return score;
    }

    public static int getMinScore(int[][] result) {
        int score = 0;

        for (int i = 0; i < 3; i++) {
            int min = Math.min(result[0][i], result[1][(i + 1) % 3]);
            score -= min;
            result[0][i] -= min;
            result[1][(i + 1) % 3] -= min;
        }

        for (int i = 0; i < 3; i++) {
            int min = Math.min(result[0][i], result[1][(i + 2) % 3]);
            score += min;
        }

        return score;
    }
}
