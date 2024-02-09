import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int imageCnt = Integer.parseInt(br.readLine());

            int squaresSum = 0;
            for (int i = 0; i < imageCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int imageSquareInches = Integer.parseInt(st.nextToken());
                int imageCntContainedFullSet = Integer.parseInt(st.nextToken());

                squaresSum += imageSquareInches * imageCntContainedFullSet;
            }

            for (int i = 1; i <= 3; i++) {
                int squareYard = 36 * 36 * i;
                sb.append(squareYard / squaresSum).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
