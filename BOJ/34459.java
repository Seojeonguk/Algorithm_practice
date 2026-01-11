import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            long fivePow = 5;
            int a = 1;

            long time = Long.parseLong(br.readLine());
            while (fivePow < time) {
                fivePow *= 5;
                a += 1;
            }

            sb.append("MIT").append(a > 1 ? String.format("^%d", a) : "").append(" time\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
