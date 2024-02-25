import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static final String ZERO = "0";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String hexadecimal = br.readLine();

        String octal = convertHexaToOctal(hexadecimal);

        sb.append(octal);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String convertHexaToOctal(String hexadecimal) {
        if (ZERO.equals(hexadecimal)) {
            return ZERO;
        }

        char[] hexadecimals = hexadecimal.toCharArray();
        Deque<Integer> binaries = new ArrayDeque<>();
        StringBuilder octal = new StringBuilder();

        for (int idx = hexadecimals.length - 1; idx >= 0; idx--) {
            int v = Integer.parseInt(String.valueOf(hexadecimals[idx]), 16);

            for (int i = 0; i < 4; i++) {
                binaries.addFirst(v % 2);
                v /= 2;
            }
        }

        while (!binaries.isEmpty()) {
            int currentOctal = 0;

            for (int i = 0; i < 3; i++) {
                int lastDigit = (binaries.isEmpty() ? 0 : binaries.pollLast());
                int bit = (1 << i);

                currentOctal += lastDigit * bit;
            }

            octal.append(currentOctal);
        }

        octal.reverse();

        for (int i = 0; i < octal.length(); i++) {
            if (octal.charAt(i) != '0') {
                octal = new StringBuilder(octal.substring(i));
                break;
            }
        }

        return octal.toString();
    }
}
