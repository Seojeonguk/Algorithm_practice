import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int TOTAL_CLOTH_CATEGORY = 5;
    static final int JOE = 0;
    static final int JEAN = 1;
    static final int JANE = 2;
    static final int JAMES = 3;
    static final int MISSING_OR_UNREADABLE = 4;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int clothesRoundHouseCnt = Integer.parseInt(br.readLine());
            if (clothesRoundHouseCnt == 0) {
                break;
            }

            int[] clothes = new int[TOTAL_CLOTH_CATEGORY];
            for (int i = 0; i < clothesRoundHouseCnt; i++) {
                String cloth = br.readLine();
                int idx = calClothIndex(cloth);
                clothes[idx]++;
            }

            for (int i = 0; i < TOTAL_CLOTH_CATEGORY; i++) {
                sb.append(clothes[i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calClothIndex(String cloth) {
        int idx = -1;

        char size = cloth.charAt(0);
        if (size == 'M' || size == 'L') {
            idx = JOE;
        } else if (size == 'S') {
            idx = JAMES;
        } else if ('0' <= size && size <= '9') {
            int clothSize = Integer.parseInt(cloth);
            if (clothSize >= 12) {
                idx = JEAN;
            } else {
                idx = JANE;
            }
        } else {
            idx = MISSING_OR_UNREADABLE;
        }

        return idx;
    }
}
