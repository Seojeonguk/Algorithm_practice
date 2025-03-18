import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[] YEARS = {0, 2024, 2025, 2025, 2026, 2026};
    static final int[] MONTHS = {0, 8, 3, 10, 5, 12};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nth = Integer.parseInt(br.readLine());
            sb.append(YEARS[nth]).append(" ").append(MONTHS[nth]).append("\n");

            bw.write(sb.toString());
        }
    }
}
