import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrLength = Integer.parseInt(br.readLine());
            int[] arr = new int[arrLength + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int ans = 0;
            boolean isOverFirst = false;
            for (int i = 1; i <= arrLength; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i - 1] > arr[i]) {
                    ans++;
                }

                if (ans > 0 && arr[1] < arr[i]) {
                    isOverFirst = true;
                }
            }

            if (ans == 0) {
                sb.append(1);
            } else if (ans == 1 && !isOverFirst) {
                sb.append(2);
            } else {
                sb.append(3);
            }

            bw.write(sb.toString());
        }
    }
}
