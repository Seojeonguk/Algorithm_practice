import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] n = br.readLine().toCharArray();
            if (n[0] == '0') {
                break;
            }

            int digit = convertSkewBinaryToDigit(n);
            sb.append(digit).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int convertSkewBinaryToDigit(char[] n) {
        int twoPow = 2;
        int digit = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            digit += (n[i] - '0') * (twoPow - 1);
            twoPow <<= 1;
        }

        return digit;
    }
}
