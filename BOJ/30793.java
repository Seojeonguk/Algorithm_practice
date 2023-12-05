import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        double preliminaryResult = Double.parseDouble(st.nextToken());
        double finalResult = Double.parseDouble(st.nextToken());

        double ans = preliminaryResult / finalResult;

        if (ans < 0.2d) {
            sb.append("weak");
        } else if (ans < 0.4d) {
            sb.append("normal");
        } else if (ans < 0.6d) {
            sb.append("strong");
        } else {
            sb.append("very strong");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
