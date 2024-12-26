import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int START_NUM = 2;
    static final int END_NUM = 9;

    static final int START_MULTIPLE_NUM = 1;
    static final int END_MULTIPLE_NUM = 9;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            sb.append(isAppear(n) ? 1 : 0);

            bw.write(sb.toString());
        }
    }

    public static boolean isAppear(int n) {
        for (int a = START_NUM; a <= END_NUM; a++) {
            for (int b = START_MULTIPLE_NUM; b <= END_MULTIPLE_NUM; b++) {
                if (n == a || n == b || a * b == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
