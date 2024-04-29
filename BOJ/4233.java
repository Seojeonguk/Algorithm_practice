import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                if (p == 0 && a == 0) {
                    break;
                }

                sb.append((!isPrime(p) && isFakePrime(p, a) ? "yes" : "no")).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int exponentiation(int base, int exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }

        int half = exponentiation(base, exponent / 2, mod);
        half = (int) (((long) half * half) % mod);
        if (exponent % 2 == 1) {
            half = (int) (((long) half * base) % mod);
        }

        return half;
    }

    public static boolean isFakePrime(int p, int a) {
        int pow = exponentiation(a, p, p);
        return pow % p == a;
    }

    public static boolean isPrime(int x) {
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
