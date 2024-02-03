import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        Game game = new Game(8);
        for (int i = 0; i < 8; i++) {
            int[] rows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            game.setMaps(rows, i);
        }

        char command = br.readLine().charAt(0);
        game.handleCommand(command);
        game.showMap(sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Game {
        int mapSize;
        long[][] maps;

        Game(int size) {
            this.mapSize = size;
            this.maps = new long[size][size];
        }

        public void setMaps(int[] row, int rowNum) {
            for (int i = 0; i < mapSize; i++) {
                this.maps[rowNum][i] = row[i];
            }
        }

        public void handleCommand(char c) {
            if (c == 'U') {
                this.up();
            } else if (c == 'D') {
                this.down();
            } else if (c == 'L') {
                this.left();
            } else if (c == 'R') {
                this.right();
            }
        }

        private void up() {
            for (int col = 0; col < mapSize; col++) {
                int curRow = 0;
                for (int row = 1; row < mapSize; row++) {
                    if (maps[row][col] == 0) {
                        continue;
                    }
                    if (maps[curRow][col] == maps[row][col]) {
                        maps[curRow][col] *= 2;
                        if (curRow != row) {
                            maps[row][col] = 0;
                        }
                        curRow++;
                    } else {
                        if (maps[curRow][col] > 0) {
                            curRow++;
                        }
                        maps[curRow][col] = maps[row][col];
                        if (curRow != row) {
                            maps[row][col] = 0;
                        }
                    }
                }
            }
        }

        private void down() {
            for (int col = 0; col < mapSize; col++) {
                int curRow = mapSize - 1;
                for (int row = mapSize - 2; row >= 0; row--) {
                    if (maps[row][col] == 0) {
                        continue;
                    }
                    if (maps[curRow][col] == maps[row][col]) {
                        maps[curRow][col] *= 2;
                        if (curRow != row) {
                            maps[row][col] = 0;
                        }
                        curRow--;
                    } else {
                        if (maps[curRow][col] > 0) {
                            curRow--;
                        }
                        maps[curRow][col] = maps[row][col];
                        if (curRow != row) {
                            maps[row][col] = 0;
                        }
                    }
                }
            }
        }

        private void left() {
            for (int row = 0; row < mapSize; row++) {
                int curCol = 0;
                for (int col = 1; col < mapSize; col++) {
                    if (maps[row][col] == 0) {
                        continue;
                    }
                    if (maps[row][curCol] == maps[row][col]) {
                        maps[row][curCol] *= 2;
                        if (curCol != col) {
                            maps[row][col] = 0;
                        }
                        curCol++;
                    } else {
                        if (maps[row][curCol] > 0) {
                            curCol++;
                        }
                        maps[row][curCol] = maps[row][col];
                        if (curCol != col) {
                            maps[row][col] = 0;
                        }
                    }
                }
            }
        }

        private void right() {
            for (int row = 0; row < mapSize; row++) {
                int curCol = mapSize - 1;
                for (int col = mapSize - 2; col >= 0; col--) {
                    if (maps[row][col] == 0) {
                        continue;
                    }
                    if (maps[row][curCol] == maps[row][col]) {
                        maps[row][curCol] *= 2;
                        if (curCol != col) {
                            maps[row][col] = 0;
                        }
                        curCol--;
                    } else {
                        if (maps[row][curCol] > 0) {
                            curCol--;
                        }
                        maps[row][curCol] = maps[row][col];
                        if (curCol != col) {
                            maps[row][col] = 0;
                        }
                    }
                }
            }
        }

        public void showMap(StringBuilder sb) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    sb.append(this.maps[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
    }
}
