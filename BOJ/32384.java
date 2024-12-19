import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String PRINT_SENTENCE = "LoveisKoreaUniversity";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int recursiveCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < recursiveCount; i++) {
                sb.append(PRINT_SENTENCE).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
