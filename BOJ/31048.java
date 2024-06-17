import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int n = Integer.parseInt(br.readLine());

                int lastDigit = 1;
                for (int multiple = 1; multiple <= n; multiple++) {
                    lastDigit = (lastDigit * multiple) % 10;
                }

                sb.append(lastDigit).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
