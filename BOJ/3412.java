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
        for (int tc = 1; tc <= testCase; tc++) {
            int throwCnt = Integer.parseInt(br.readLine());

            int score = 0;
            for (int throwNum = 0; throwNum < throwCnt; throwNum++) {
                StringTokenizer hitPoints = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(hitPoints.nextToken());
                int y = Integer.parseInt(hitPoints.nextToken());

                for (int radius = 20; radius <= 200; radius += 20) {
                    if (x * x + y * y <= radius * radius) {
                        score += (11 - radius / 20);
                        break;
                    }
                }
            }

            sb.append(score).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
