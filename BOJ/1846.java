import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            if (n <= 3) {
                addLine(sb, -1);
            } else if (n % 2 == 0) {
                addLine(sb, n / 2);
                for (int i = 1; i < n / 2; i++) {
                    addLine(sb, i);
                }
                for (int i = n / 2; i < n - 1; i++) {
                    addLine(sb, i + 2);
                }
                addLine(sb, n / 2 + 1);
            } else {
                addLine(sb, n / 2 + 1);
                for (int i = 1; i < n / 2 + 1; i++) {
                    addLine(sb, i);
                }
                addLine(sb, n);
                for (int i = n / 2 + 2; i < n; i++) {
                    addLine(sb, i);
                }
            }

            bw.write(sb.toString());
        }
    }

    public static void addLine(StringBuilder sb, int value) {
        sb.append(value).append("\n");
    }
}
