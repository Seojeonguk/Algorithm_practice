import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrSize = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(getLongestSubTriangleSequence(arr));

            bw.write(sb.toString());
        }
    }

    public static int getLongestSubTriangleSequence(int[] arr) {
        Arrays.sort(arr);
        int longestSubTriangleSequence = Math.min(arr.length, 2);
        for (int i = 1; i < arr.length; i++) {
            int sum = arr[i - 1] + arr[i];

            int upperSumIdx = arr.length;
            for (int j = i + 1; j < arr.length; j++) {
                if (sum <= arr[j]) {
                    upperSumIdx = j;
                    break;
                }
            }

            longestSubTriangleSequence = Math.max(longestSubTriangleSequence, upperSumIdx - i + 1);
        }
        return longestSubTriangleSequence;
    }
}
