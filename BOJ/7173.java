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

        StringTokenizer classInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(classInfo.nextToken());
        int colSize = Integer.parseInt(classInfo.nextToken());

        int[][] interested = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            char[] rows = br.readLine().toCharArray();
            for (int col = 0; col < colSize; col++) {
                interested[row][col] = rows[col] - '0';
            }
        }

        double classAttention = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                int aroundFriends = 0;
                int sumStudentDiffAttention = 0;

                if (row > 0) {
                    sumStudentDiffAttention += Math.abs(interested[row][col] - interested[row - 1][col]);
                    aroundFriends++;
                }

                if (col > 0) {
                    sumStudentDiffAttention += Math.abs(interested[row][col] - interested[row][col - 1]);
                    aroundFriends++;
                }

                if (row < rowSize - 1) {
                    sumStudentDiffAttention += Math.abs(interested[row][col] - interested[row + 1][col]);
                    aroundFriends++;
                }

                if (col < colSize - 1) {
                    sumStudentDiffAttention += Math.abs(interested[row][col] - interested[row][col + 1]);
                    aroundFriends++;
                }

                double studentAttention = 1.0 * sumStudentDiffAttention / aroundFriends;
                classAttention += studentAttention;
            }
        }

        sb.append(String.format("%.4f", classAttention));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
