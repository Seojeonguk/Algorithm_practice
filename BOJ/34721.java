import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final String EXPRESSION_SENTENCE = "I love DGU";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();

            int expressionCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < expressionCnt; i++) {
                sb.append(EXPRESSION_SENTENCE).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
