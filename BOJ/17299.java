import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int MAX_VALUE = 1000000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrSize = Integer.parseInt(br.readLine());
            int[] arr = new int[arrSize];
            int[] appearedCounts = new int[MAX_VALUE + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arrSize; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                appearedCounts[arr[i]]++;
            }

            int[] ans = new int[arrSize];
            Arrays.fill(ans, -1);

            Stack<int[]> s = new Stack<>();
            for (int idx = arrSize - 1; idx >= 0; idx--) {
                int currentF = appearedCounts[arr[idx]];

                while (!s.isEmpty() && s.peek()[0] <= currentF) {
                    s.pop();
                }

                if (!s.isEmpty()) {
                    ans[idx] = s.peek()[1];
                }

                s.push(new int[]{currentF, arr[idx]});
            }

            for (int idx = 0; idx < arrSize; idx++) {
                sb.append(ans[idx]).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
