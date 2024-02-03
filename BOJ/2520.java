import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[] REQUIRED_MATERIALS = {8, 8, 4, 1, 9};
    static final int[] REQUIRED_TOPPINGS = {1, 30, 25, 10};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            double minDividedMaterial = Double.MAX_VALUE;
            for (int i = 0; i < REQUIRED_MATERIALS.length; i++) {
                int material = Integer.parseInt(st.nextToken());
                double divide = 1.0d * material / REQUIRED_MATERIALS[i];
                minDividedMaterial = Math.min(minDividedMaterial, divide);
            }
            int makeDoughCnt = (int) (minDividedMaterial * 16);

            st = new StringTokenizer(br.readLine());
            int makePanCakeToUseTopping = 0;
            for (int i = 0; i < REQUIRED_TOPPINGS.length; i++) {
                int topping = Integer.parseInt(st.nextToken());
                makePanCakeToUseTopping += topping / REQUIRED_TOPPINGS[i];
            }

            sb.append(Math.min(makeDoughCnt, makePanCakeToUseTopping)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
