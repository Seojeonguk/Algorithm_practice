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

        int matrixSize = Integer.parseInt(br.readLine());
        int[][] chickens = new int[matrixSize + 1][matrixSize + 1];
        int[][] prefixSums = new int[matrixSize + 1][matrixSize + 1];
        for (int i = 1; i <= matrixSize; i++) {
            StringTokenizer cols = new StringTokenizer(br.readLine());
            for (int j = 1; j <= matrixSize; j++) {
                chickens[i][j] = Integer.parseInt(cols.nextToken());
                prefixSums[i][j] = chickens[i][j] + prefixSums[i - 1][j] + prefixSums[i][j - 1] - prefixSums[i - 1][j - 1];
            }
        }

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            StringTokenizer coordinates = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(coordinates.nextToken());
            int c1 = Integer.parseInt(coordinates.nextToken());
            int r2 = Integer.parseInt(coordinates.nextToken());
            int c2 = Integer.parseInt(coordinates.nextToken());

            int total = prefixSums[r2][c2] - prefixSums[r2][c1 - 1] - prefixSums[r1 - 1][c2] + prefixSums[r1 - 1][c1 - 1];
            int inner = prefixSums[r2 - 1][c2 - 1] - prefixSums[r2 - 1][c1] - prefixSums[r1][c2 - 1] + prefixSums[r1][c1];
            int outside = total - inner;

            sb.append(-outside + inner).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
