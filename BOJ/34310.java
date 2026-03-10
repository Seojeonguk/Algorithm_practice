import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final String STRAGGLE_ZERO = "NO STRAGGLERS";

    public static void main(String[] args) throws Exception {
        int evenCnt = Integer.parseInt(br.readLine());

        long straggle = 0;
        for (int i = 0; i < evenCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            String direction = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if ("IN".equals(direction)) {
                straggle += num;
            } else {
                straggle -= num;
            }
        }

        sb.append(straggle > 0 ? straggle : STRAGGLE_ZERO);

        bw.write(sb.toString());
        bw.flush();
    }
}
