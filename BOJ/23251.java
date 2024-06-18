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
                int k = Integer.parseInt(br.readLine());
                sb.append(k * 23).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
