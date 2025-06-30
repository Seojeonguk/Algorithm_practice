import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nth = Integer.parseInt(br.readLine());

            long[] fibSeries = new long[nth + 1];
            for (int idx = 1; idx <= Math.min(nth, 3); idx++) {
                fibSeries[idx] = 1;
            }

            for (int idx = 4; idx <= nth; idx++) {
                fibSeries[idx] = fibSeries[idx - 1] + fibSeries[idx - 3];
            }

            sb.append(fibSeries[nth]);

            bw.write(sb.toString());
        }
    }
}
