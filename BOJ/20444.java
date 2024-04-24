import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            sb.append(canMakeKPaper(n, k) ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }

    public static boolean canMakeKPaper(long n, long k) {
        long a = (n + 2) * (n + 2) - 4 * k;
        return isSqrt(a);
    }

    public static boolean isSqrt(long a) {
        long sqrt = (long) Math.sqrt(a);
        return sqrt * sqrt == a;
    }
}
