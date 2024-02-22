import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer secretMessageInfo = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(secretMessageInfo.nextToken());
            int colSize = Integer.parseInt(secretMessageInfo.nextToken());

            char[][] secretMessages = new char[rowSize][colSize];
            String secretMessage = secretMessageInfo.nextToken();
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    secretMessages[row][col] = secretMessage.charAt(row * colSize + col);
                }
            }

            String originalMessage = decodeMessage(rowSize, colSize, secretMessages);
            sb.append(originalMessage.trim()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String decodeMessage(int rowSize, int colSize, char[][] secretMessage) {
        StringBuilder originalMessage = new StringBuilder();
        boolean[][] isVisit = new boolean[rowSize][colSize];
        int checkingSize = rowSize * colSize;

        int row = 0, col = 0, dir = 0;
        while (checkingSize >= 5) {
            StringBuilder binary = new StringBuilder();
            int checkingCnt = 4;
            do {
                isVisit[row][col] = true;
                binary.append(secretMessage[row][col]);
                if (shouldTurn(rowSize, colSize, row, col, dir, isVisit)) {
                    dir = (dir + 1) % 4;
                }
                row += DIRS[dir][0];
                col += DIRS[dir][1];
            } while (checkingCnt-- > 0);

            int a = Integer.parseInt(binary.toString(), 2);
            if (a == 0) {
                originalMessage.append(" ");
            } else {
                originalMessage.append((char) ('A' + a - 1));
            }

            checkingSize -= 5;
        }

        return originalMessage.toString();
    }

    public static boolean shouldTurn(int rowSize, int colSize, int row, int col, int dir, boolean[][] isVisit) {
        int nextRow = row + DIRS[dir][0];
        int nextCol = col + DIRS[dir][1];

        if (isOut(rowSize, colSize, nextRow, nextCol)) {
            return true;
        }

        if (isVisit[nextRow][nextCol]) {
            return true;
        }

        return false;
    }

    public static boolean isOut(int rowSize, int colSize, int row, int col) {
        return (row < 0 || col < 0 || row > rowSize - 1 || col > colSize - 1);
    }
}
