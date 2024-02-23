import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer inputs = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(inputs.nextToken());
        int b = Integer.parseInt(inputs.nextToken());

        for (int pow = a + 1; pow <= 62; pow++) {
            long powValue = (1L << pow);

            if (String.valueOf(powValue).charAt(0) - '0' == b) {
                sb.append(pow);
                break;
            }
        }

        if (sb.length() == 0) {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
