import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int listCnt = Integer.parseInt(st.nextToken());
            int cutPointCnt = Integer.parseInt(st.nextToken());
            int rollLength = Integer.parseInt(st.nextToken());

            int[] cutPoints = new int[cutPointCnt + 2];
            for (int idx = 1; idx <= cutPointCnt; idx++) {
                cutPoints[idx] = Integer.parseInt(br.readLine());
            }
            cutPoints[cutPointCnt + 1] = rollLength;
            Arrays.sort(cutPoints);

            TreeSet<Integer> diff = new TreeSet<>();
            for (int i = 0; i < cutPoints.length; i++) {
                for (int j = i + 1; j < cutPoints.length; j++) {
                    diff.add(cutPoints[j] - cutPoints[i]);
                }
            }

            int[] diffs = diff.stream().mapToInt(Integer::intValue).sorted().toArray();

            for (int queryNum = 0; queryNum < listCnt; queryNum++) {
                int cutCnt = Integer.parseInt(br.readLine());
                sb.append(calMinLength(diffs, cutPoints, cutCnt)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int calMinLength(int[] diff, int[] cutPoints, int cutCnt) {
        int left = 0, right = diff.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            int start = cutPoints[0];
            int cuttingCnt = 0;
            for (int i = 0; i < cutPoints.length; i++) {
                if (cutPoints[i] - cutPoints[start] >= diff[mid]) {
                    cuttingCnt++;
                    start = i;
                }
            }

            if (cuttingCnt - 1 >= cutCnt) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return diff[left - 1];
    }
}
