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

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int dummy = Integer.parseInt(st.nextToken());
                int shortestCookie = Integer.parseInt(st.nextToken());
                int diffCookie = Integer.parseInt(st.nextToken());

                int totalCookie = 0;
                for (int i = 0; i < dummy; i++) {
                    totalCookie += shortestCookie + diffCookie * i;
                }

                sb.append(totalCookie).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
