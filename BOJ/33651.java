import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static char[] ORIGIN_SIGN = {'U', 'A', 'P', 'C'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] vandalizedSign = br.readLine().toCharArray();

            int vandalizedSignIndex = 0;
            for (char c : ORIGIN_SIGN) {
                if (vandalizedSignIndex == vandalizedSign.length || c != vandalizedSign[vandalizedSignIndex]) {
                    sb.append(c);
                } else if (c == vandalizedSign[vandalizedSignIndex]) {
                    vandalizedSignIndex++;
                }
            }

            bw.write(sb.toString());
        }
    }
}
