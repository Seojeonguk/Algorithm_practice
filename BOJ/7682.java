import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tictactoe = br.readLine();
            if ("end".equals(tictactoe)) {
                break;
            }

            sb.append(isValid(tictactoe) ? "valid" : "invalid").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isValid(String game) {
        char[][] tictactoe = new char[3][3];

        int xCnt = 0;
        int oCnt = 0;
        int puttingCnt = 0;
        for (int idx = 0; idx < 9; idx++) {
            tictactoe[idx / 3][idx % 3] = game.charAt(idx);
            if (tictactoe[idx / 3][idx % 3] == 'X') {
                xCnt++;
                puttingCnt++;
            } else if (tictactoe[idx / 3][idx % 3] == 'O') {
                oCnt++;
                puttingCnt++;
            }
        }

        if (xCnt != oCnt && xCnt != oCnt + 1) {
            return false;
        }

        boolean isXWin = checkEnd(tictactoe, 'X');
        boolean isOWin = checkEnd(tictactoe, 'O');

        if (isXWin && isOWin) {
            return false;
        }

        if (puttingCnt != 9 && !isXWin && !isOWin) {
            return false;
        }

        if (isOWin && xCnt > oCnt) {
            return false;
        }

        if (isXWin && xCnt <= oCnt) {
            return false;
        }

        return true;
    }

    public static boolean checkEnd(char[][] tictactoe, char turn) {
        boolean isEnd = false;
        int leftUp = 0, rightDown = 0;
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int col = 0;
            if (tictactoe[i][i] == turn) {
                rightDown++;
            }
            if (tictactoe[2 - i][i] == turn) {
                leftUp++;
            }
            for (int j = 0; j < 3; j++) {
                if (tictactoe[i][j] == turn) {
                    row++;
                }
                if (tictactoe[j][i] == turn) {
                    col++;
                }
            }
            if (row == 3 || col == 3) {
                isEnd = true;
            }
        }
        if (rightDown == 3 || leftUp == 3) {
            isEnd = true;
        }

        return isEnd;
    }
}
