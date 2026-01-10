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
        int totalObstacles = Integer.parseInt(st.nextToken());
        int foundObstacles = Integer.parseInt(st.nextToken());

        boolean[] isFoundObstacles = new boolean[totalObstacles + 1];
        for (int i = 0; i < foundObstacles; i++) {
            int foundObstacle = Integer.parseInt(br.readLine());
            isFoundObstacles[foundObstacle] = true;
        }

        int foundObstacleCnt = 0;
        for (int i = 0; i < totalObstacles; i++) {
            if (!isFoundObstacles[i]) {
                sb.append(i).append("\n");
            } else {
                foundObstacleCnt += 1;
            }
        }

        sb.append(String.format("Mario got %d of the dangerous obstacles.", foundObstacleCnt));

        bw.write(sb.toString());
        bw.flush();
    }
}
