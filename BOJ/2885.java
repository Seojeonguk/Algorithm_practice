import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int requiredChocolates = Integer.parseInt(br.readLine());
            int[] ans = solve(requiredChocolates);
            sb.append(ans[0]).append(" ").append(ans[1]);

            bw.write(sb.toString());
        }
    }

    public static int[] solve(int requiredChocolates) {
        int[] ans = new int[2];

        int highestBit = Integer.highestOneBit(requiredChocolates);
        if (highestBit == requiredChocolates) {
            ans[0] = requiredChocolates;
            return ans;
        }

        ans[0] = highestBit * 2;
        int lowestBit = Integer.lowestOneBit(requiredChocolates);
        int cnt = 1;
        while (lowestBit != highestBit) {
            lowestBit *= 2;
            cnt++;
        }

        ans[1] = cnt;

        return ans;
    }
}
