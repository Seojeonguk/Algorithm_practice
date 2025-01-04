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
                char[] values = br.readLine().toCharArray();

                int sum = 0;
                for (char c : values) {
                    sum += (c - '9');
                }

                sb.append(sum % 9 == 0 ? "YES" : "NO").append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
