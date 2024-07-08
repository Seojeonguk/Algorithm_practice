import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            sb.append(sumRotation(n));

            bw.write(sb.toString());
        }
    }

    public static long sumRotation(int n) {
        String strN = String.valueOf(n);
        String repeatN = strN.repeat(2);

        long sum = 0;
        int length = strN.length();
        for (int idx = 0; idx < length; idx++) {
            sum += Long.parseLong(repeatN.substring(idx, idx + length));
        }

        return sum;
    }
}
