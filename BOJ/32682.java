import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int MAX = 1000000;

    static final String ODD = "O";
    static final String SQUARE = "S";
    static final String NONE = "EMPTY";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            boolean[] isPow = new boolean[MAX + 1];
            for (int i = 0; i * i <= MAX; i++) {
                isPow[i * i] = true;
            }

            int testCase = Integer.parseInt(br.readLine());

            for (int tc = 0; tc < testCase; tc++) {
                int n = Integer.parseInt(br.readLine());

                boolean isSatisfied = false;

                if (n % 2 == 1) {
                    sb.append(ODD);
                    isSatisfied = true;
                }

                if (isPow[n]) {
                    sb.append(SQUARE);
                    isSatisfied = true;
                }

                if (!isSatisfied) {
                    sb.append(NONE);
                }

                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
