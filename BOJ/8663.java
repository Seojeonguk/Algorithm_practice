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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int roadWidth = Integer.parseInt(st.nextToken());
            int jumps = Integer.parseInt(st.nextToken());

            int current = 0;
            int jumpCnt = 0;
            for (int jump = jumps; current < roadWidth && jump > 1; jump /= 2) {
                current += jump;
                jumpCnt++;
            }

            if (current < roadWidth) {
                jumpCnt += roadWidth - current;
            }

            sb.append(jumpCnt);

            bw.write(sb.toString());
        }
    }
}
