import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        for (int idx = 0; idx < arrSize; idx++) {
            arr[idx] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int left = 0, right = 0;
        int minAddedCnt = Integer.MAX_VALUE;
        while (left < arrSize && right < arrSize) {

            while (right < arrSize && arr[left] + 4 >= arr[right]) {
                right++;
            }
            minAddedCnt = Math.min(minAddedCnt, Math.max(0, 5 - right + left));
            left++;
        }

        sb.append(minAddedCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
