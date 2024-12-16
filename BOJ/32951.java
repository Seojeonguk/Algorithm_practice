import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int STANDARD_YEAR = 2024;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int curiousYear = Integer.parseInt(br.readLine());

            sb.append(curiousYear - STANDARD_YEAR);

            bw.write(sb.toString());
        }
    }
}
