import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final int[][] ADD = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrLength = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(calMinOperationCnt(arr));

            bw.write(sb.toString());
        }
    }

    public static int calMinOperationCnt(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        int minOperationCnt = Integer.MAX_VALUE;
        for (int i = 0; i < ADD.length; i++) {
            int[] brr = arr.clone();
            brr[0] += ADD[i][0];
            brr[1] += ADD[i][1];

            int operationCnt = 0;
            if (ADD[i][0] != 0) {
                operationCnt++;
            }

            if (ADD[i][1] != 0) {
                operationCnt++;
            }

            int diff = brr[1] - brr[0];
            for (int j = 2; j < brr.length; j++) {
                int nextDiff = brr[j] - brr[j - 1];

                if (Math.abs(diff - nextDiff) > 1) {
                    operationCnt = Integer.MAX_VALUE;
                    break;
                }

                if (Math.abs(diff - nextDiff) == 1) {
                    operationCnt++;
                    brr[j] = brr[j - 1] + diff;
                }
            }

            minOperationCnt = Math.min(minOperationCnt, operationCnt);
        }

        return minOperationCnt == Integer.MAX_VALUE ? -1 : minOperationCnt;
    }
}
