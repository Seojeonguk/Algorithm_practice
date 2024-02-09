import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int problemCnt = Integer.parseInt(br.readLine());

        for (int problem = 1; problem <= problemCnt; problem++) {
            int n = Integer.parseInt(br.readLine());

            int total = 0;
            int current = 0;
            for (int i = 1; i <= n; i++) {
                current += i;
                total += current;
            }
            sb.append(String.format("%d: %d %d\n", problem, n, total));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
