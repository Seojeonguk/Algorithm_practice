import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; ; tc++) {
            int buyingPencilCnt = Integer.parseInt(br.readLine());
            if (buyingPencilCnt == 0) {
                break;
            }

            List<int[]> solutions = findAllSolutions(buyingPencilCnt);

            sb.append(String.format("Case %d:\n%d pencils for %d cents\n", tc, buyingPencilCnt, buyingPencilCnt));

            if (solutions.isEmpty()) {
                sb.append("No solution found.\n\n");
            } else {
                for (int[] solution : solutions) {
                    sb.append(solution[0]).append(" at four cents each").append("\n");
                    sb.append(solution[1]).append(" at two for a penny").append("\n");
                    sb.append(solution[2]).append(" at four for a penny").append("\n");
                    sb.append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static List<int[]> findAllSolutions(int buyingPencilCnt) {
        List<int[]> solutions = new ArrayList<>();

        for (int fourCent = 1; fourCent < buyingPencilCnt; fourCent++) {
            for (int twoPenny = 1; twoPenny < buyingPencilCnt; twoPenny++) {
                if (fourCent + twoPenny >= buyingPencilCnt) {
                    break;
                }
                int fourPenny = buyingPencilCnt - fourCent - twoPenny;
                int sum = fourCent + twoPenny + fourPenny;
                if (sum > buyingPencilCnt) {
                    break;
                }

                int pennyPencils = buyingPencilCnt - fourCent * 4;
                pennyPencils *= 4;

                if (twoPenny * 2 + fourPenny == pennyPencils) {
                    int[] solution = new int[3];
                    solution[0] = fourCent;
                    solution[1] = twoPenny;
                    solution[2] = fourPenny;

                    solutions.add(solution);
                }
            }
        }

        return solutions;
    }
}
