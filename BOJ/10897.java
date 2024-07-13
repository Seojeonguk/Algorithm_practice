import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int investigatedGeneration = Integer.parseInt(br.readLine());
            StringTokenizer kthNums = new StringTokenizer(br.readLine());

            long currentChildNum = 0;
            long added = 1;
            long currentLine = 1;

            for (int generation = 1; generation <= investigatedGeneration; generation++) {
                long kth = Long.parseLong(kthNums.nextToken());

                added = (((added - 1) * generation) % MOD + kth) % MOD;
                sb.append((currentChildNum + added) % MOD).append("\n");

                currentLine = (currentLine * generation) % MOD;
                currentChildNum = (currentChildNum + currentLine) % MOD;
            }

            bw.write(sb.toString());
        }
    }
}
