import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());

        int required = 64 - Long.numberOfLeadingZeros(n);

        int b = 1;
        while (b < required) {
            b <<= 1;
        }

        sb.append(b).append(" ").append(b == 1 ? "bit" : "bits");

        bw.write(sb.toString());
        bw.flush();
    }
}
