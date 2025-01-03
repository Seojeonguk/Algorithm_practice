import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final double CHICKEN_PRICE_PER_STICK = 0.8;
    static final double BEEF_PRICE_PER_STICK = 1.0;
    static final double LAMB_PRICE_PER_STICK = 1.2;
    static final double NASI_PRICE_PER_STICK = 0.8;

    static final double CHICKEN_PRICE_PER_KG = 15.5;
    static final double BEEF_PRICE_PER_KG = 32.0;
    static final double LAMB_PRICE_PER_KG = 40.0;
    static final double NASI_PRICE_PER_KG = 0.2;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            for (int tc = 1; ; tc++) {
                int days = Integer.parseInt(br.readLine());

                if (days == 0) {
                    break;
                }

                double ans = 0;

                for (int day = 0; day < days; day++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int chickenSales = Integer.parseInt(st.nextToken());
                    int beefSales = Integer.parseInt(st.nextToken());
                    int lambSales = Integer.parseInt(st.nextToken());
                    int nasiSales = Integer.parseInt(st.nextToken());

                    double chicken = chickenSales / 85.0;
                    double beef = beefSales / 85.0;
                    double lamb = lambSales / 85.0;

                    ans += chickenSales * CHICKEN_PRICE_PER_STICK;
                    ans += beefSales * BEEF_PRICE_PER_STICK;
                    ans += lambSales * LAMB_PRICE_PER_STICK;
                    ans += nasiSales * NASI_PRICE_PER_STICK;

                    ans -= chicken * CHICKEN_PRICE_PER_KG;
                    ans -= beef * BEEF_PRICE_PER_KG;
                    ans -= lamb * LAMB_PRICE_PER_KG;
                    ans -= nasiSales * NASI_PRICE_PER_KG;
                }

                sb.append(String.format("Case #%d: RM%.2f\n", tc, ans));
            }

            bw.write(sb.toString());
        }
    }
}
