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
            long n = Long.parseLong(br.readLine());
            boolean isPow = false;
            for (long i = 1; i * i <= n; i++) {
                if (i * i == n) {
                    isPow = true;
                    break;
                }
            }

            sb.append(isPow ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
