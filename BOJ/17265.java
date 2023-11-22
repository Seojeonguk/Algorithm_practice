import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int mapSize = Integer.parseInt(br.readLine());
        char[][] maps = new char[mapSize][mapSize];

        for (int row = 0; row < mapSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < mapSize; col++) {
                maps[row][col] = st.nextToken().charAt(0);
            }
        }

        int[][] maxMaps = new int[mapSize][mapSize];
        int[][] minMaps = new int[mapSize][mapSize];

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                if (row == 0 && col == 0) {
                    maxMaps[row][col] = minMaps[row][col] = maps[row][col] - '0';
                    continue;
                }
                if ((row + col) % 2 > 0) {
                    continue;
                }
                maxMaps[row][col] = Integer.MIN_VALUE;
                minMaps[row][col] = Integer.MAX_VALUE;
                int currentValue = maps[row][col] - '0';
                if (row >= 2) {
                    int calculationMaxResult = cal(maxMaps[row - 2][col], maps[row - 1][col], currentValue);
                    int calculationMinResult = cal(minMaps[row - 2][col], maps[row - 1][col], currentValue);

                    maxMaps[row][col] = Math.max(maxMaps[row][col], calculationMaxResult);
                    minMaps[row][col] = Math.min(minMaps[row][col], calculationMinResult);
                }
                if (row >= 1 && col >= 1) {
                    int leftCalculationMaxResult = cal(maxMaps[row - 1][col - 1], maps[row][col - 1], currentValue);
                    int leftCalculationMinResult = cal(minMaps[row - 1][col - 1], maps[row][col - 1], currentValue);

                    int upCalculationMaxResult = cal(maxMaps[row - 1][col - 1], maps[row - 1][col], currentValue);
                    int upCalculationMinResult = cal(minMaps[row - 1][col - 1], maps[row - 1][col], currentValue);

                    maxMaps[row][col] = Math.max(maxMaps[row][col], Math.max(leftCalculationMaxResult, upCalculationMaxResult));
                    minMaps[row][col] = Math.min(minMaps[row][col], Math.min(leftCalculationMinResult, upCalculationMinResult));
                }
                if (col >= 2) {
                    int calculationMaxResult = cal(maxMaps[row][col - 2], maps[row][col - 1], currentValue);
                    int calculationMinResult = cal(minMaps[row][col - 2], maps[row][col - 1], currentValue);

                    maxMaps[row][col] = Math.max(maxMaps[row][col], calculationMaxResult);
                    minMaps[row][col] = Math.min(minMaps[row][col], calculationMinResult);
                }
            }
        }

        sb.append(maxMaps[mapSize - 1][mapSize - 1]).append(" ").append(minMaps[mapSize - 1][mapSize - 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int cal(int a, char op, int b) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else return a / b;
    }
}
