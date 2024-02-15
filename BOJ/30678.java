import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static boolean[][] DRAW_STAR = {{false, false, true, false, false}, {false, false, true, false, false}, {true, true, true, true, true}, {false, true, true, true, false}, {false, true, false, true, false}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] stars = drawStar(n);

        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars.length; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char[][] drawStar(int n) {
        int size = 1;
        for (int i = 0; i < n; i++) {
            size *= 5;
        }

        char[][] stars = new char[size][size];
        if (n == 0) {
            stars[0][0] = '*';
            return stars;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stars[i][j] = ' ';
            }
        }
        solve(stars, size / 5, size / 2, size / 2, true);
        return stars;
    }

    public static void solve(char[][] stars, int size, int x, int y, boolean range) {
        if (size == 1) {
            if (range) {
                drawStar(stars, x, y);
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                solve(stars, size / 5, x + size * (i - 2), y + size * (j - 2), range & DRAW_STAR[i][j]);
            }
        }
    }

    public static void drawStar(char[][] stars, int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (DRAW_STAR[i][j]) {
                    stars[x - 2 + i][y - 2 + j] = '*';
                }
            }
        }
    }
}
