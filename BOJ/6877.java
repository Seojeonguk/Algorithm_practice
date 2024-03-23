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

        StringTokenizer displayInfo = new StringTokenizer(br.readLine());
        int displayX = Integer.parseInt(displayInfo.nextToken());
        int displayY = Integer.parseInt(displayInfo.nextToken());

        int curX = 0, curY = 0;
        while (true) {
            StringTokenizer movedDistanceInfo = new StringTokenizer(br.readLine());
            int movedX = Integer.parseInt(movedDistanceInfo.nextToken());
            int movedY = Integer.parseInt(movedDistanceInfo.nextToken());

            if (movedX == 0 && movedY == 0) {
                break;
            }

            curX += movedX;
            curY += movedY;

            if (curX < 0) {
                curX = 0;
            } else if (curX > displayX) {
                curX = displayX;
            }

            if (curY < 0) {
                curY = 0;
            } else if (curY > displayY) {
                curY = displayY;
            }

            sb.append(curX).append(" ").append(curY).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
