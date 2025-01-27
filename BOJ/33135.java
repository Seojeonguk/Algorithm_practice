import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] originalStrings = br.readLine().toCharArray();

            for (int idx = originalStrings.length - 1; idx >= 0; idx--) {
                if (originalStrings[idx] <= originalStrings[idx - 1]) {
                    sb.append(idx);
                    break;
                }
            }

            bw.write(sb.toString());
        }
    }
}
