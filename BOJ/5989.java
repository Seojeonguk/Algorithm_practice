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

        StringTokenizer fieldInfo = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(fieldInfo.nextToken());
        int rowSize = Integer.parseInt(fieldInfo.nextToken());
        int plowInstructionCnt = Integer.parseInt(fieldInfo.nextToken());

        boolean[][] plowedSquares = new boolean[rowSize][colSize];
        int totalPlowedSquares = 0;
        for (int plowInstruction = 0; plowInstruction < plowInstructionCnt; plowInstruction++) {
            StringTokenizer coordinatesInfo = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(coordinatesInfo.nextToken()) - 1;
            int sx = Integer.parseInt(coordinatesInfo.nextToken()) - 1;
            int dy = Integer.parseInt(coordinatesInfo.nextToken()) - 1;
            int dx = Integer.parseInt(coordinatesInfo.nextToken()) - 1;

            for (int row = sx; row <= dx; row++) {
                for (int col = sy; col <= dy; col++) {
                    if (!plowedSquares[row][col]) {
                        plowedSquares[row][col] = true;
                        totalPlowedSquares++;
                    }
                }
            }
        }

        sb.append(totalPlowedSquares);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
