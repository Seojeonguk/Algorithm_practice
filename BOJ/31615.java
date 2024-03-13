import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int sum = a + b;
        sb.append(calDigits(sum));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calDigits(int x) {
        int digits = 0;
        while (x > 0) {
            digits++;
            x /= 10;
        }
        return digits;
    }
}
