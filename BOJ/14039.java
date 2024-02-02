import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int SQUARE_SIZE = 4;

    public static void main(String[] args) throws Exception {
        int[][] magicSquares = new int[SQUARE_SIZE][SQUARE_SIZE];
        for (int i = 0; i < SQUARE_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SQUARE_SIZE; j++) {
                magicSquares[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashSet<Integer> sums = new HashSet<>();
        for (int i = 0; i < SQUARE_SIZE; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < SQUARE_SIZE; j++) {
                rowSum += magicSquares[i][j];
                colSum += magicSquares[j][i];
            }

            sums.add(rowSum);
            sums.add(colSum);
        }

        sb.append(sums.size() == 1 ? "magic" : "not magic");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
