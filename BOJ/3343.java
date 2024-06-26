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

            StringTokenizer st = new StringTokenizer(br.readLine());
            long requiredRose = Long.parseLong(st.nextToken());
            long aBundleRose = Long.parseLong(st.nextToken());
            long aCost = Long.parseLong(st.nextToken());
            long bBundleRose = Long.parseLong(st.nextToken());
            long bCost = Long.parseLong(st.nextToken());

            if (bBundleRose * aCost > aBundleRose * bCost) {
                long bundleTemp = aBundleRose;
                aBundleRose = bBundleRose;
                bBundleRose = bundleTemp;

                long costTemp = aCost;
                aCost = bCost;
                bCost = costTemp;
            }

            long minCost = Long.MAX_VALUE;
            for (int b = 0; b < aBundleRose; b++) {
                long remainedRose = requiredRose - b * bBundleRose;
                long a = Math.max(0, remainedRose / aBundleRose + (remainedRose % aBundleRose > 0 ? 1 : 0));

                minCost = Math.min(minCost, a * aCost + b * bCost);
                if (remainedRose < 0) {
                    break;
                }
            }

            sb.append(minCost);

            bw.write(sb.toString());
        }
    }
}
