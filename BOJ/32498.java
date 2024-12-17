import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int candidateProblemCnt = Integer.parseInt(br.readLine());
            int[] candidateProblemLevels = new int[candidateProblemCnt];
            for (int idx = 0; idx < candidateProblemCnt; idx++) {
                candidateProblemLevels[idx] = Integer.parseInt(br.readLine());
            }

            sb.append(calExcludedProblemCnt(candidateProblemLevels));

            bw.write(sb.toString());
        }
    }

    public static int calExcludedProblemCnt(int[] candidateProblemLevels) {
        int excludedProblemCnt = 0;

        for (int level : candidateProblemLevels) {
            if (level % 2 == 1) {
                excludedProblemCnt++;
            }
        }

        return excludedProblemCnt;
    }
}
