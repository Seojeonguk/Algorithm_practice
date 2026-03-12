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
        int buildingCnt = Integer.parseInt(br.readLine());
        int minX = 100;
        int minY = 100;
        int maxX = -100;
        int maxY = -100;

        for (int i = 0; i < buildingCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            minX = Math.min(minX, sx);
            minY = Math.min(minY, sy);
            maxX = Math.max(maxX, ex);
            maxY = Math.max(maxY, ey);

            sb.append((maxX - minX + maxY - minY) * 2).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
