import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();
        for (int idx = 0; idx < str.length; idx++) {
            int v = str[idx];
            int sum = 0;
            while (v != 0) {
                sum += v % 10;
                v /= 10;
            }
            for (int i = 0; i < sum; i++) {
                sb.append(str[idx]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
