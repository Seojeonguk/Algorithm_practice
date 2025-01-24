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
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            int canDivideOnlyOne = 0;
            for (int i = 1; i <= n; i++) {
                if ((i % a == 0 && i % b != 0) || (i % a != 0 && i % b == 0)) {
                    canDivideOnlyOne++;
                }
            }

            sb.append(canDivideOnlyOne);

            bw.write(sb.toString());
        }
    }
}
