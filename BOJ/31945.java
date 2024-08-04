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

            int testCase = Integer.parseInt(br.readLine());
            int[] indexes = new int[4];
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < 4; i++) {
                    indexes[i] = Integer.parseInt(st.nextToken());
                }

                sb.append(isOnOneSide(indexes) ? "YES" : "NO").append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isOnOneSide(int[] indexes) {
        Arrays.sort(indexes);

        if (indexes[0] == 0 || indexes[0] == 4) {
            if (calSameDiff(indexes, 1) == 3) {
                return true;
            }
        }

        if (indexes[0] == 0 || indexes[0] == 1) {
            if (calSameDiff(indexes, 2) == 3) {
                return true;
            }
        }

        if (indexes[0] == 0 || indexes[0] == 2) {
            if (indexes[1] - indexes[0] == 1 && indexes[0] + 4 == indexes[2] && indexes[1] + 4 == indexes[3]) {
                return true;
            }
        }

        return false;
    }

    public static int calSameDiff(int[] arr, int diff) {
        int diffCnt = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (Math.abs(arr[i] - arr[i + 1 ]) == diff) {
                diffCnt++;
            }
        }

        return diffCnt;
    }
}
