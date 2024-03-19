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
        int arrLength = Integer.parseInt(st.nextToken());
        int maxPossibleDelete = Integer.parseInt(st.nextToken());

        int[] arr = new int[arrLength + 1];
        int[] prefixSums = new int[arrLength + 1];
        StringTokenizer arrInfo = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= arrLength; idx++) {
            arr[idx] = Integer.parseInt(arrInfo.nextToken());
            prefixSums[idx] = prefixSums[idx - 1] + (arr[idx] % 2 == 0 ? 1 : 0);
        }

        int ans = 0;
        int left = 1, right = 1;
        while (right <= arrLength) {
            int evenCnt = prefixSums[right] - prefixSums[left - 1];
            int oddCnt = right - left + 1 - evenCnt;

            if (oddCnt <= maxPossibleDelete) {
                ans = Math.max(ans, evenCnt);
                right++;
            } else {
                left++;
            }
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
