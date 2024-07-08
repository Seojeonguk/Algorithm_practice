import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final long MOD = 500000009;
    static final long MUL = 4;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int heights = Integer.parseInt(br.readLine());
            long requiredPerson = 1;

            long ans = 0;
            for (int height = 0; height < heights; height++) {
                ans = (ans + requiredPerson) % MOD;
                requiredPerson = (requiredPerson * MUL) % MOD;
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
