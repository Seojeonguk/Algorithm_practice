import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static final int HAMMER_CNT = 10;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            double[] probabilities = new double[HAMMER_CNT];
            for (int i = 0; i < HAMMER_CNT; i++) {
                probabilities[i] = Double.parseDouble(br.readLine());
            }

            Arrays.sort(probabilities);

            double ans = 1000000000;
            for (int i = HAMMER_CNT - 1, enforce = 0; i > 0; i--, enforce++) {
                ans = ans * ((probabilities[i] / (enforce + 1)));
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
