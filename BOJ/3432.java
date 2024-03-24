import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int ROW_SIZE = 5;
    static final int COL_SIZE = 5;
    static final int CONTINUOUS_CNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            char[][] ttt = new char[ROW_SIZE][COL_SIZE];
            for (int row = 0; row < ROW_SIZE; row++) {
                ttt[row] = br.readLine().toCharArray();
            }

            boolean existAThreeMarble = calThreeMarble(ttt, 'A');
            boolean existBThreeMarble = calThreeMarble(ttt, 'B');

            if (existAThreeMarble == existBThreeMarble) {
                sb.append("draw\n");
            } else if (existAThreeMarble) {
                sb.append("A wins\n");
            } else {
                sb.append("B wins\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean calThreeMarble(char[][] ttt, char who) {
        for (int row = 0; row < ROW_SIZE; row++) {
            for (int col = 0; col < COL_SIZE; col++) {
                int continuousCnt = 0;
                if (col <= COL_SIZE - CONTINUOUS_CNT) {
                    for (int i = 0; i < CONTINUOUS_CNT; i++) {
                        if (ttt[row][col + i] == who) {
                            continuousCnt++;
                        }
                    }
                    if (continuousCnt == CONTINUOUS_CNT) {
                        return true;
                    }
                }

                continuousCnt = 0;
                if (row <= ROW_SIZE - CONTINUOUS_CNT) {
                    for (int i = 0; i < CONTINUOUS_CNT; i++) {
                        if (ttt[row + i][col] == who) {
                            continuousCnt++;
                        }
                    }
                    if (continuousCnt == CONTINUOUS_CNT) {
                        return true;
                    }
                }

                continuousCnt = 0;
                if (col <= COL_SIZE - CONTINUOUS_CNT && row <= ROW_SIZE - CONTINUOUS_CNT) {
                    for (int i = 0; i < CONTINUOUS_CNT; i++) {
                        if (ttt[row + i][col + i] == who) {
                            continuousCnt++;
                        }
                    }
                    if (continuousCnt == CONTINUOUS_CNT) {
                        return true;
                    }
                }

                continuousCnt = 0;
                if (col >= CONTINUOUS_CNT - 1 && row <= ROW_SIZE - CONTINUOUS_CNT) {
                    for (int i = 0; i < CONTINUOUS_CNT; i++) {
                        if (ttt[row + i][col - i] == who) {
                            continuousCnt++;
                        }
                    }

                    if (continuousCnt == CONTINUOUS_CNT) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
