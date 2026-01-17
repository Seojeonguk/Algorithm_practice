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
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int shipRow = Integer.parseInt(st.nextToken());
        int shipCol = Integer.parseInt(st.nextToken());

        int recognizedDistance = Integer.parseInt(br.readLine());

        int attackTargetCnt = 0;

        for (int row = 1; row <= rowSize; row++) {
            for (int col = 1; col <= colSize; col++) {
                if (row == shipRow && col == shipCol) {
                    continue;
                }

                int distance = calDistance(row, col, shipRow, shipCol);
                if (distance <= recognizedDistance) {
                    attackTargetCnt++;
                }
            }
        }

        sb.append(attackTargetCnt);

        bw.write(sb.toString());
        bw.flush();
    }

    public static int calDistance(int x, int y, int targetX, int targetY) {
        return Math.abs(x - targetX) + Math.abs(y - targetY);
    }
}
