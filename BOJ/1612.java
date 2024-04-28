import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            sb.append(solve(n));

            bw.write(sb.toString());
        }
    }

    public static int solve(int n) {
        if (n % 5 == 0 || n % 2 == 0) {
            return -1;
        }

        int mod = 0;
        for (int i = 1; ; i++) {
            mod = (10 * mod + 1) % n;
            if (mod % n == 0) {
                return i;
            }
        }
    }
}
