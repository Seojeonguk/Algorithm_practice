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

            int part = Integer.parseInt(br.readLine());

            int[] weights = new int[part + 1];
            StringTokenizer weightToken = new StringTokenizer(br.readLine());
            for (int i = 1; i <= part; i++) {
                weights[i] = Integer.parseInt(weightToken.nextToken());
            }

            int[] energies = new int[part + 1];
            StringTokenizer energyToken = new StringTokenizer(br.readLine());
            for (int i = 1; i <= part; i++) {
                energies[i] = Integer.parseInt(energyToken.nextToken());
            }

            long[] dp = new long[part + 1];
            for (int i = 1; i <= part; i++) {
                dp[i] = dp[i - 1] + (long) weights[i] * energies[i];
                int maxWeight = weights[i];
                int maxEnergy = energies[i];
                for (int j = i - 1; j > 0; j--) {
                    maxWeight = Math.max(maxWeight, weights[j]);
                    maxEnergy = Math.max(maxEnergy, energies[j]);
                    dp[i] = Math.min(dp[i], dp[j - 1] + (long) maxWeight * maxEnergy);
                }
            }

            sb.append(dp[part]);

            bw.write(sb.toString());
        }
    }
}
