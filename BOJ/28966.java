import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalFlowerPot = Integer.parseInt(br.readLine());
        int[] flowers = new int[totalFlowerPot + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= totalFlowerPot; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        int[] changeIndexes = getChangeIndexes(flowers);
        sb.append(changeIndexes[0]).append(" ").append(changeIndexes[1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] getChangeIndexes(int[] flowers) {
        if (flowers.length == 3) {
            if (flowers[1] % 2 == 0 && flowers[2] % 2 == 1) {
                return new int[]{1, 2};
            } else {
                return new int[]{-1, -1};
            }
        }

        int diffEvenCnt = 0, diffOddCnt = 0, diffEvenLastIdx = 1, diffOddLastIdx = 3;
        for (int i = 1; i < flowers.length; i++) {
            if (i % 2 == 1 && flowers[i] % 2 == 0) {
                diffOddCnt++;
                diffOddLastIdx = i;
            } else if (i % 2 == 0 && flowers[i] % 2 == 1) {
                diffEvenCnt++;
                diffEvenLastIdx = i;
            }
        }

        int[] changeIndexes = new int[2];
        if ((diffOddCnt == 0 && diffEvenCnt == 0) || (diffOddCnt == 1 && diffEvenCnt == 1)) {
            changeIndexes[0] = diffOddLastIdx;
            changeIndexes[1] = diffEvenLastIdx;
        } else {
            changeIndexes[0] = changeIndexes[1] = -1;
        }

        return changeIndexes;
    }
}
