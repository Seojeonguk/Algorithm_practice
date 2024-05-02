import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int PROBLEM_COUNT = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int participatedTeam = Integer.parseInt(br.readLine());

            int faithfulTeam = 0;
            for (int teamNum = 1; teamNum <= participatedTeam; teamNum++) {
                StringTokenizer solvedTimeInfo = new StringTokenizer(br.readLine());

                int[] solvedTimes = new int[PROBLEM_COUNT];
                boolean isSolved = false;
                for (int solvedTimeIdx = 0; solvedTimeIdx < PROBLEM_COUNT; solvedTimeIdx++) {
                    int solvedTime = Integer.parseInt(solvedTimeInfo.nextToken());
                    solvedTimes[solvedTimeIdx] = (solvedTime == -1 ? Integer.MAX_VALUE : solvedTime);

                    if (solvedTime >= 0) {
                        isSolved = true;
                    }
                }

                boolean isSolvedProblemInOrder = true;
                for (int solvedTimeIdx = 0; solvedTimeIdx < PROBLEM_COUNT - 1; solvedTimeIdx++) {
                    if (solvedTimes[solvedTimeIdx] > solvedTimes[solvedTimeIdx + 1]) {
                        isSolvedProblemInOrder = false;
                    }
                }

                if (isSolved && isSolvedProblemInOrder) {
                    faithfulTeam++;
                }
            }

            sb.append(faithfulTeam);

            bw.write(sb.toString());
        }
    }
}
