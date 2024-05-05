import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            char[][] maps = new char[rowSize][colSize];
            int sx = -1, sy = -1;

            for (int row = 0; row < rowSize; row++) {
                maps[row] = br.readLine().toCharArray();

                for (int col = 0; col < colSize; col++) {
                    if (maps[row][col] == 'G') {
                        sx = row;
                        sy = col;
                    }
                }
            }

            sb.append(calMaxSweetPotato(rowSize, colSize, time, maps, sx, sy, 0));

            bw.write(sb.toString());
        }
    }

    public static int calMaxSweetPotato(int rowSize, int colSize, int remainderTime, char[][] maps, int currentX, int currentY, int sweetPotato) {
        if (remainderTime == 0) {
            return sweetPotato;
        }

        int maxSweetPotato = 0;
        for (int[] direction : DIRECTIONS) {
            int nx = currentX + direction[0];
            int ny = currentY + direction[1];

            if (isOut(rowSize, colSize, nx, ny) || maps[nx][ny] == '#') {
                continue;
            }

            boolean existSweetPotato = (maps[nx][ny] == 'S');
            if (existSweetPotato) {
                maps[nx][ny] = '.';
            }

            maxSweetPotato = Math.max(maxSweetPotato, calMaxSweetPotato(rowSize, colSize, remainderTime - 1, maps, nx, ny, sweetPotato + (existSweetPotato ? 1 : 0)));

            if (existSweetPotato) {
                maps[nx][ny] = 'S';
            }
        }

        return maxSweetPotato;
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
