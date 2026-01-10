import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final int[][] REQUIRED_ARCANE_MONSTERS = {
            {200, 210, 220},
            {210, 220, 225},
            {220, 225, 230},
            {225, 230, 235},
            {230, 235, 245},
            {235, 245, 250}
    };

    static final int[][] REQUIRED_AUTHENTIC_MONSTERS = {
            {260, 265, 270},
            {265, 270, 275},
            {270, 275, 280},
            {275, 280, 285},
            {280, 285, 290},
            {285, 290, 295},
            {290, 295, 300},
    };

    public static void main(String[] args) throws Exception {
        int level = Integer.parseInt(br.readLine());

        calKilledMonsters(level, REQUIRED_ARCANE_MONSTERS);
        calKilledMonsters(level, REQUIRED_AUTHENTIC_MONSTERS);

        bw.write(sb.toString());
        bw.flush();
    }

    public static void calKilledMonsters(int level, int[][] monsters) {
        for (int i = 0; i < monsters.length; i++) {
            int x = 0;
            for (int j = 0; j < monsters[i].length; j++) {
                if (monsters[i][j] <= level) {
                    x = 500 - 200 * j;
                }
            }
            sb.append(x).append(" ");
        }
        sb.append("\n");
    }
}
