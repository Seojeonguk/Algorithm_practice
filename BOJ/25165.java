import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final String NOT_FOUND_MONSTER_RESULT = "YES!";
    static final String FOUND_MONSTER_RESULT = "NO...";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer map = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(map.nextToken());
            int colSize = Integer.parseInt(map.nextToken());

            StringTokenizer ari = new StringTokenizer(br.readLine());
            int startCol = Integer.parseInt(ari.nextToken());
            int startDir = Integer.parseInt(ari.nextToken());

            StringTokenizer monster = new StringTokenizer(br.readLine());
            int monsterX = Integer.parseInt(monster.nextToken());
            int monsterY = Integer.parseInt(monster.nextToken());

            if (monsterX == 1) {
                if (startDir == 0 && startCol >= monsterY) {
                    sb.append(FOUND_MONSTER_RESULT);
                } else if (startDir == 1 && startCol <= monsterY) {
                    sb.append(FOUND_MONSTER_RESULT);
                } else {
                    sb.append(NOT_FOUND_MONSTER_RESULT);
                }
            } else if (monsterX == rowSize) {
                if (rowSize % 2 == startDir) {
                    sb.append(FOUND_MONSTER_RESULT);
                } else {
                    sb.append(NOT_FOUND_MONSTER_RESULT);
                }
            } else {
                sb.append(FOUND_MONSTER_RESULT);
            }

            bw.write(sb.toString());
        }
    }
}
