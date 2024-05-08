import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            long n = Long.parseLong(br.readLine());
            sb.append(solve(n));

            bw.write(sb.toString());
        }
    }

    public static long solve(long n) {
        for (long mul = 1; ; mul *= 10) {
            for (int i = 0; i < mul; i++) {
                long next = n * mul + i;
                if (isAllMod(n, next)) {
                    return next;
                }
            }
        }
    }

    public static boolean isAllMod(long n, long x) {
        long temp = n;
        while (temp > 0) {
            long remainder = temp % 10;
            if (remainder > 0 && x % remainder != 0) {
                return false;
            }
            temp /= 10;
        }

        return true;
    }
}
