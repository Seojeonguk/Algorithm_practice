import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            int ans = 0;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    ans++;
                    if (i * i != n) {
                        ans++;
                    }
                }
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
