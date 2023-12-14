import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            char[] str = br.readLine().toCharArray();
            if (str.length == 1) {
                sb.append(str[0]).append("\n");
                continue;
            }
            sb.append(str).append("\n");
            for (int i = 1; i < str.length - 1; i++) {
                sb.append(str[i]);
                for (int j = 0; j < str.length - 2; j++) {
                    sb.append(" ");
                }
                sb.append(str[str.length - i - 1]).append("\n");
            }
            for (int i = 0; i < str.length; i++) {
                sb.append(str[str.length - i - 1]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
