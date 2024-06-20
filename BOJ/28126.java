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

            int robotMoveCnt = Integer.parseInt(br.readLine());
            char[] robotMoves = br.readLine().toCharArray();
            int up = 0, right = 0, diagonal = 0;
            for (char move : robotMoves) {
                if (move == 'U') {
                    right++;
                } else if (move == 'R') {
                    up++;
                } else if (move == 'X') {
                    diagonal++;
                }
            }

            int explorePointCnt = Integer.parseInt(br.readLine());
            int canMoveExplorePoint = 0;
            for (int i = 0; i < explorePointCnt; i++) {
                StringTokenizer explorePoint = new StringTokenizer(br.readLine());
                int pointX = Integer.parseInt(explorePoint.nextToken()) - 1;
                int pointY = Integer.parseInt(explorePoint.nextToken()) - 1;

                int moveDiagonal = Math.min(diagonal, Math.min(pointX, pointY));
                pointX = pointX - moveDiagonal - up;
                pointY = pointY - moveDiagonal - right;

                if (pointX <= 0 && pointY <= 0) {
                    canMoveExplorePoint++;
                }
            }

            sb.append(canMoveExplorePoint);

            bw.write(sb.toString());
        }
    }
}
