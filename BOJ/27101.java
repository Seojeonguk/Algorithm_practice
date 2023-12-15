import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int matrixSize = Integer.parseInt(br.readLine());
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int possibleFact = getPossibleFact(matrix);

        sb.append(possibleFact);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getPossibleFact(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != 0) {
                return 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    continue;
                }
                if (matrix[i][j] <= 0) {
                    return 2;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return 3;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[i][j] + matrix[j][k] < matrix[i][k]) {
                        return 4;
                    }
                }
            }
        }
        
        return 0;
    }
}
