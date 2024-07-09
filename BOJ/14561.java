import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long value = Long.parseLong(st.nextToken());
                int radix = Integer.parseInt(st.nextToken());

                sb.append(isPalindrome(value, radix) ? 1 : 0).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isPalindrome(long value, int radix) {
        char[] radixStr = Long.toString(value, radix).toCharArray();

        for (int i = 0; i < radixStr.length / 2; i++) {
            if (radixStr[i] != radixStr[radixStr.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
