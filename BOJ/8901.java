import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= testCase; tc++) {
                int[] hasChemical = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] chemicalPrices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                int maxCost = 0;
                for (int i = 0; i <= 1000; i++) {
                    if (hasChemical[0] < i || hasChemical[1] < i) {
                        break;
                    }

                    for (int j = 0; j <= 1000; j++) {
                        if (hasChemical[0] < i || hasChemical[1] < i + j || hasChemical[2] < j) {
                            break;
                        }

                        int[] remainder = {hasChemical[0] - i, hasChemical[1] - i - j, hasChemical[2] - j};
                        maxCost = Math.max(maxCost, i * chemicalPrices[0] + j * chemicalPrices[1] + Math.min(remainder[0], remainder[2]) * chemicalPrices[2]);
                    }
                }

                sb.append(maxCost).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
