import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final int TOTAL_ROUND = 18;
    static final String ALGOSIA = "Algosia";
    static final String BAJTEK = "Bajtek";
    static final String TIE = "remis";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] algosiResults = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bajtekResults = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sb.append(calGameResult(algosiResults, bajtekResults));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calGameResult(int[] a, int[] b) {
        int aSum = Arrays.stream(a).sum();
        int bSum = Arrays.stream(b).sum();

        if (aSum != bSum) {
            return (aSum > bSum ? ALGOSIA : BAJTEK);
        }

        for (int score = 10; score >= 0; score--) {
            int finalScore = score;
            int aScoreCnt = (int) Arrays.stream(a).filter(x -> finalScore == x).count();
            int bScoreCnt = (int) Arrays.stream(b).filter(x -> finalScore == x).count();

            if (aScoreCnt != bScoreCnt) {
                return (aScoreCnt > bScoreCnt ? ALGOSIA : BAJTEK);
            }
        }

        return TIE;
    }
}
