import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstRowStitchCnt = Integer.parseInt(st.nextToken());
            int totalProjectRow = Integer.parseInt(st.nextToken());
            int repeatingPatternCnt = Integer.parseInt(st.nextToken());

            if (firstRowStitchCnt == 0 && totalProjectRow == 0 && repeatingPatternCnt == 0) {
                break;
            }

            int[] repeatingPatterns = new int[repeatingPatternCnt];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < repeatingPatternCnt; i++) {
                repeatingPatterns[i] = Integer.parseInt(st.nextToken());
            }

            int totalCompletedProjectStitch = calStitch(firstRowStitchCnt, totalProjectRow, repeatingPatterns);
            sb.append(totalCompletedProjectStitch).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calStitch(int firstStitchCnt, int totalProjectRow, int[] repeatingPatterns) {
        int repeatingPatternIdx = 0;
        int currentRowStitchCnt = firstStitchCnt;
        int totalStitch = 0;
        for (int row = 0; row < totalProjectRow; row++) {
            totalStitch += currentRowStitchCnt;
            currentRowStitchCnt += repeatingPatterns[repeatingPatternIdx];
            repeatingPatternIdx = (repeatingPatternIdx + 1) % repeatingPatterns.length;
        }

        return totalStitch;
    }
}
