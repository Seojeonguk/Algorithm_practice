import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BigInteger factorial = new BigInteger("1");
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            BigInteger multiple = new BigInteger(String.valueOf(i));
            factorial = factorial.multiply(multiple);
        }

        int zeroCnt = 0;
        while (factorial.compareTo(BigInteger.ZERO) != 0) {
            int remainder = factorial.remainder(BigInteger.TEN).intValue();
            if (remainder == 0) {
                zeroCnt++;
            }
            factorial = factorial.divide(BigInteger.TEN);
        }
        sb.append(zeroCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
