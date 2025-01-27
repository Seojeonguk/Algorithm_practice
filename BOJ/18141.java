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

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(isOnlyInt(arr) ? "yes" : "no");

            bw.write(sb.toString());
        }
    }

    public static boolean isOnlyInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < arr.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if ((arr[i] - arr[j]) % arr[k] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
