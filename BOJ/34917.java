import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append((j == 0 || j == n - 1 || (i <= n / 2 && Math.abs(n / 2 - j) == (n / 2 - i))) ? "#" : ".");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
