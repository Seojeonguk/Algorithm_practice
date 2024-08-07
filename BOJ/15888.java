import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final String RESULT_TWO_ROOT_INT_AND_TWO_SQUARE = "이수근";
    static final String RESULT_TWO_ROOT_INT = "정수근";
    static final String OTHER = "둘다틀렸근";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(distinctResult(a, b, c));

            bw.write(sb.toString());
        }
    }

    public static String distinctResult(int a, int b, int c) {
        int root = b * b - 4 * a * c;

        int sqrt = -1;
        for (int i = 1; i * i <= root; i++) {
            if (i * i == root) {
                sqrt = i;
                break;
            }
        }

        if (sqrt == -1) {
            return OTHER;
        }

        int n = -b - sqrt;
        int m = -b + sqrt;

        if (n % 2 == 1 || m % 2 == 1) {
            return OTHER;
        }

        n /= 2;
        m /= 2;

        if (n % a != 0 || m % a != 0) {
            return OTHER;
        }

        n /= a;
        m /= a;

        if (n < 2 || Integer.lowestOneBit(n) != Integer.highestOneBit(n)) {
            return RESULT_TWO_ROOT_INT;
        }

        if (m < 2 || Integer.lowestOneBit(m) != Integer.highestOneBit(m)) {
            return RESULT_TWO_ROOT_INT;
        }

        return RESULT_TWO_ROOT_INT_AND_TWO_SQUARE;
    }
}
