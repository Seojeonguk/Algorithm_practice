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
        final int[] MIN_TOTAL_PASS_SCORES = {0, 100, 90, 95, 90, 80};
        final int[] MIN_SCORES = {0, 19, 19, 19, -1, -1};
        int person = Integer.parseInt(br.readLine());
        while (person-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int grade = Integer.parseInt(st.nextToken());
            int knowledge = Integer.parseInt(st.nextToken());
            int reading = Integer.parseInt(st.nextToken());
            int listening = Integer.parseInt(st.nextToken());

            if (2 < grade) {
                sb.append("NO").append("\n");
                continue;
            }

            if (listening < 50) {
                sb.append("NO").append("\n");
                continue;
            }

            if (knowledge * 3 < MIN_TOTAL_PASS_SCORES[grade] && reading * 3 < MIN_TOTAL_PASS_SCORES[grade]) {
                sb.append("YES").append("\n");
                continue;
            }

            if (knowledge < 22 || reading < 22) {
                sb.append("YES").append("\n");
                continue;
            }


            sb.append("NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
