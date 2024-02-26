import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int changedCnt = Integer.parseInt(st.nextToken());
        int[] arr = new int[arrSize];
        StringTokenizer arrInfo = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < arrSize; idx++) {
            arr[idx] = Integer.parseInt(arrInfo.nextToken());
        }

        int[] ans = findKthChange(arr, changedCnt);
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] findKthChange(int[] arr, int changedCnt) {
        int change = 0;
        for (int last = arr.length - 1; last >= 0; last--) {
            int maxValue = 0, maxValueIdx = 0;
            for (int i = 0; i <= last; i++) {
                if (maxValue < arr[i]) {
                    maxValue = arr[i];
                    maxValueIdx = i;
                }
            }

            if (last != maxValueIdx) {
                change++;

                int temp = arr[maxValueIdx];
                arr[maxValueIdx] = arr[last];
                arr[last] = temp;

                if (change == changedCnt) {
                    return new int[]{arr[maxValueIdx], arr[last]};
                }
            }
        }

        return new int[]{-1};
    }
}
