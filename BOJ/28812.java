import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int storeCnt = Integer.parseInt(st.nextToken());
        int gasCost = Integer.parseInt(st.nextToken());

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < storeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int modelCost = Integer.parseInt(st.nextToken());
            int deliveryCost = Integer.parseInt(st.nextToken());
            int requiredGas = Integer.parseInt(st.nextToken());

            int cost = modelCost + deliveryCost + gasCost * requiredGas;
            minCost = Math.min(minCost, cost);
        }

        sb.append(minCost);

        bw.write(sb.toString());
        bw.flush();
    }
}
