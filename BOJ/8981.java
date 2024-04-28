import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrLength = Integer.parseInt(br.readLine());
            int[] arr = new int[arrLength];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < arrLength; idx++) {
                arr[idx] = Integer.parseInt(st.nextToken());
            }

            int[] ans = new int[arrLength];
            int idx = 0;
            for (int i = 0; i < arrLength; i++) {
                idx = (idx + (i == 0 ? 0 : arr[i - 1])) % arrLength;
                while (ans[idx] != 0) {
                    idx = (idx + 1) % arrLength;
                }

                ans[idx] = arr[i];
            }

            sb.append(arrLength).append("\n");
            for (int value : ans) {
                sb.append(value).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
