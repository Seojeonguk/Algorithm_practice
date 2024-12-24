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
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int fizzCnt = 0;
            int buzzCnt = 0;
            int fizzbuzzCnt = 0;

            for (int i = 1; i <= num; i++) {
                if (i % a == 0 && i % b == 0) {
                    fizzbuzzCnt++;
                } else if (i % a == 0) {
                    fizzCnt++;
                } else if (i % b == 0) {
                    buzzCnt++;
                }
            }

            sb.append(fizzCnt).append(" ").append(buzzCnt).append(" ").append(fizzbuzzCnt);

            bw.write(sb.toString());
        }
    }
}
