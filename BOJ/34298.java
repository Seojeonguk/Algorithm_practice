import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int remained = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        if (remained == 0) {
            sb.append(0);
        } else {
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum = (sum + Integer.parseInt(st.nextToken())) % mod;
                if (sum % mod == remained) {
                    sb.append(i + 1);
                    break;
                }
            }
        }

        if (sb.isEmpty()) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
