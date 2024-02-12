import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Loop1:
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cherylScore = 0, taniaScore = 0;
            while (st.hasMoreTokens()) {
                char card = st.nextToken().charAt(0);
                if (card == '#') {
                    break Loop1;
                }
                if (card == '*') {
                    break;
                }
                int num = (card == 'A' ? 1 : card - '0');
                if ((num & 1) == 0) {
                    taniaScore++;
                } else {
                    cherylScore++;
                }
            }
            if (taniaScore > cherylScore) {
                sb.append("Tania").append("\n");
            } else if (taniaScore < cherylScore) {
                sb.append("Cheryl").append("\n");
            } else {
                sb.append("Draw").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
