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

    static final int TOTAL_PROBLEM = 11;

    public static void main(String[] args) throws Exception {
        Problem[] problems = new Problem[TOTAL_PROBLEM];
        for (int i = 0; i < TOTAL_PROBLEM; i++) {
            st = new StringTokenizer(br.readLine());
            int solvingTime = Integer.parseInt(st.nextToken());
            int mistakeCount = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(solvingTime, mistakeCount);
        }

        int minimumPenalty = 0;

        Arrays.sort(problems, Comparator.comparingInt(o -> o.solvingTime));

        int time = 0;
        for (int i = 0; i < TOTAL_PROBLEM; i++) {
            time += problems[i].solvingTime;
            minimumPenalty += time + problems[i].mistakeCount * 20;
        }

        sb.append(minimumPenalty);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Problem {
        int solvingTime;
        int mistakeCount;

        Problem(int solvingTime, int mistakeCount) {
            this.solvingTime = solvingTime;
            this.mistakeCount = mistakeCount;
        }
    }
}
