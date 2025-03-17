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

            for (int tc = 1; tc <= testCase; tc++) {
                String[] splittedStrings = br.readLine().split(" ");
                sb.append("Case #").append(tc).append(": ");
                for (int idx = splittedStrings.length - 1; idx >= 0; idx--) {
                    sb.append(splittedStrings[idx]).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
