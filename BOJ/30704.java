import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int tileCnt = Integer.parseInt(br.readLine());
            int sqrt = (int) Math.sqrt(tileCnt);

            int length = 4 * sqrt;
            if (sqrt * sqrt + sqrt < tileCnt) {
                length += 4;
            } else if (sqrt * sqrt < tileCnt) {
                length += 2;
            }

            sb.append(length).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
