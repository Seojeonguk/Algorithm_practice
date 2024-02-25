import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer powInfo = new StringTokenizer(br.readLine());
        long n = Long.parseLong(powInfo.nextToken());
        int power = Integer.parseInt(powInfo.nextToken());

        BigInteger pow = calPow(n, power);
        String strPow = pow.toString();
        for (int i = 0; i < strPow.length(); i += 70) {
            sb.append(strPow, i, Math.min(i + 70, strPow.length())).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static BigInteger calPow(long n, int power) {
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < power; i++) {
            res = res.multiply(BigInteger.valueOf(n));
        }

        return res;
    }
}
