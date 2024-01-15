import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalFaucet = Integer.parseInt(br.readLine());
        boolean[] isOnFaucets = new boolean[totalFaucet];
        Arrays.fill(isOnFaucets, true);
        int[] waterQuantities = new int[totalFaucet];

        long currentWaterQuantity = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalFaucet; i++) {
            waterQuantities[i] = Integer.parseInt(st.nextToken());
            currentWaterQuantity += waterQuantities[i];
        }

        sb.append(currentWaterQuantity).append("\n");
        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int faucetNum = Integer.parseInt(st.nextToken()) - 1;
            if (command == 1) {
                int changedWaters = Integer.parseInt(st.nextToken());
                if (isOnFaucets[faucetNum]) {
                    currentWaterQuantity += changedWaters - waterQuantities[faucetNum];
                }
                waterQuantities[faucetNum] = changedWaters;
            } else if (command == 2) {

                isOnFaucets[faucetNum] = !isOnFaucets[faucetNum];
                currentWaterQuantity += (isOnFaucets[faucetNum] ? waterQuantities[faucetNum] : -waterQuantities[faucetNum]);
            }
            sb.append(currentWaterQuantity).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
