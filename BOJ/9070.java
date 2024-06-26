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

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int kindCnt = Integer.parseInt(br.readLine());

                int minCost = Integer.MAX_VALUE;
                double minWeightPerCost = 0;

                while (kindCnt-- > 0) {
                    StringTokenizer meats = new StringTokenizer(br.readLine());
                    int weight = Integer.parseInt(meats.nextToken());
                    int cost = Integer.parseInt(meats.nextToken());

                    double weightPerCost = 1.0 * weight / cost;
                    int compare = Double.compare(minWeightPerCost, weightPerCost);
                    if (compare < 0) {
                        minWeightPerCost = weightPerCost;
                        minCost = cost;
                    } else if (compare == 0) {
                        minCost = Math.min(minCost, cost);
                    }
                }

                sb.append(minCost).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
