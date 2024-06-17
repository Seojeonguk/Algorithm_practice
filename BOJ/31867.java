import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int EVEN_EVEN = 0;
    static final int ODD_ODD = 1;
    static final int NONE = -1;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            char[] values = br.readLine().toCharArray();

            int oddCnt = 0, evenCnt = 0;
            for (char c : values) {
                if (isEven(c)) {
                    evenCnt++;
                } else {
                    oddCnt++;
                }
            }

            if (evenCnt > oddCnt) {
                sb.append(EVEN_EVEN);
            } else if (evenCnt < oddCnt) {
                sb.append(ODD_ODD);
            } else {
                sb.append(NONE);
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isEven(char c) {
        return (c - '0') % 2 == 0;
    }
}
