import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int initBudget = Integer.parseInt(br.readLine());
            int lossRatio = Integer.parseInt(br.readLine());

            double current = initBudget - initBudget * lossRatio / 100.0;
            double result = initBudget / current - 1;

            sb.append(result * 100);

            bw.write(sb.toString());
        }
    }
}
