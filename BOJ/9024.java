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
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int left = 0, right = arr.length - 1;
            int minDiff = Integer.MAX_VALUE, minCnt = 0;
            while (left < right) {
                int sum = arr[left] + arr[right];
                int diff = Math.abs(sum - m);
                if (minDiff > diff) {
                    minDiff = diff;
                    minCnt = 1;
                } else if (minDiff == diff) {
                    minCnt++;
                }

                if (m >= sum) {
                    left++;
                }
                if (m <= sum) {
                    right--;
                }
            }

            sb.append(minCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
