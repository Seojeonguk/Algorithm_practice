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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int blackTileCnt = Integer.parseInt(st.nextToken());
        int whiteTileCnt = Integer.parseInt(st.nextToken());

        int maxTileCnt = Math.max(blackTileCnt, whiteTileCnt);
        int minTileCnt = Math.min(blackTileCnt, whiteTileCnt);

        int squareSideLength = 0;
        while (true) {
            int neededTile = squareSideLength * squareSideLength;
            int neededMinTile = neededTile / 2;
            int neededMaxTile = (neededTile + 1) / 2;

            if (neededMinTile > minTileCnt || neededMaxTile > maxTileCnt) {
                break;
            }
            squareSideLength++;
        }

        if (squareSideLength == 1) {
            sb.append("Impossible");
        } else {
            sb.append(squareSideLength - 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
