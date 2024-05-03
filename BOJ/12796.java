import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int k = Integer.parseInt(br.readLine());

            sb.append(3).append("\n");
            for (int i = 0; i < 3; i++) {
                sb.append(1).append(" ");
            }
            sb.append(k + 1);

            bw.write(sb.toString());
        }
    }
}
