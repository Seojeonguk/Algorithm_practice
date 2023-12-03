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
        int candidateCnt = Integer.parseInt(br.readLine());

        while (candidateCnt-- > 0) {
            int vote = Integer.parseInt(br.readLine());

            for (int i = 0; i < vote / 5; i++) {
                sb.append("++++ ");
            }
            for (int i = 0; i < vote % 5; i++) {
                sb.append("|");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
