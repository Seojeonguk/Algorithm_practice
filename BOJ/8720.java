import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int campParticipantCnt = Integer.parseInt(st.nextToken());
            int campWorkCnt = Integer.parseInt(st.nextToken());

            int[][] campParticipantResults = new int[campParticipantCnt][campWorkCnt];
            for (int participant = 0; participant < campParticipantCnt; participant++) {
                StringTokenizer workResults = new StringTokenizer(br.readLine());
                for (int work = 0; work < campWorkCnt; work++) {
                    campParticipantResults[participant][work] = Integer.parseInt(workResults.nextToken());
                }
            }

            int[] sameScores = new int[campParticipantCnt];

            for (int i = 0; i < campWorkCnt; i++) {
                if (campParticipantResults[0][i] == 100) {
                    for (int j = 0; j < campParticipantCnt; j++) {
                        if (campParticipantResults[j][i] == 100) {
                            sameScores[j]++;
                        }
                    }
                }
            }

            int max = Arrays.stream(sameScores).max().orElse(0);
            long ret = Arrays.stream(sameScores).filter(x -> x == max).count();

            sb.append(1).append(" ").append(ret);

            bw.write(sb.toString());
        }
    }
}
