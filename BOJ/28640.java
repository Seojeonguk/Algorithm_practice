import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String firstDomino = br.readLine();
        String secondDomino = br.readLine();

        int[] firstSideDots = calSideDots(firstDomino);
        int[] secondSideDots = calSideDots(secondDomino);

        boolean canCombineDomino = false;
        for (int i = 0; i < firstSideDots.length; i++) {
            for (int j = 0; j < secondSideDots.length; j++) {
                if (firstSideDots[i] == secondSideDots[j]) {
                    canCombineDomino = true;
                }
            }
        }

        sb.append(canCombineDomino ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] calSideDots(String domino) {
        int leftDotCnt = domino.indexOf('|');
        int rightDotCnt = domino.length() - leftDotCnt - 1;

        return new int[]{leftDotCnt, rightDotCnt};
    }
}
