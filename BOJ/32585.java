import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            long n = Long.parseLong(br.readLine());

            BigInteger bigInteger = BigInteger.ONE;
            BigInteger result = bigInteger
                    .multiply(BigInteger.valueOf(n))
                    .multiply(BigInteger.valueOf(n + 1))
                    .multiply(BigInteger.valueOf(n + 2))
                    .divide(BigInteger.valueOf(6));

            sb.append(result);

            bw.write(sb.toString());
        }
    }
}
