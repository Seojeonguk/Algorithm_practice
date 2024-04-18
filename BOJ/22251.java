import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] TOGGLE = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0},
    };

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int buildingHeights = Integer.parseInt(st.nextToken());
            int displayLength = Integer.parseInt(st.nextToken());
            int maxToggleCnt = Integer.parseInt(st.nextToken());
            int currentHeight = Integer.parseInt(st.nextToken());

            int[] currentDigits = getDigits(currentHeight, displayLength);

            int makePossibleInterruption = 0;
            for (int height = 1; height <= buildingHeights; height++) {
                if (height == currentHeight) {
                    continue;
                }
                int[] targetDigits = getDigits(height, displayLength);

                int toggleCnt = 0;
                for (int i = 0; i < displayLength; i++) {
                    toggleCnt += TOGGLE[currentDigits[i]][targetDigits[i]];
                }

                if (toggleCnt <= maxToggleCnt) {
                    makePossibleInterruption++;
                }
            }

            sb.append(makePossibleInterruption);

            bw.write(sb.toString());
        }
    }

    public static int[] getDigits(int x, int length) {
        int[] digits = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = x % 10;
            x /= 10;
        }

        return digits;
    }
}
