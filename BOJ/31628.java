import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int LENGTH = 10;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[][] eggplantColors = new String[LENGTH][LENGTH];
        for (int row = 0; row < LENGTH; row++) {
            eggplantColors[row] = br.readLine().split(" ");
        }

        boolean canMakeEggplantLine = false;

        for (int i = 0; i < LENGTH; i++) {
            int sameColorRowCnt = 0;
            int sameColorColCnt = 0;
            for (int j = 0; j < LENGTH; j++) {
                if (eggplantColors[i][0].equals(eggplantColors[i][j])) {
                    sameColorRowCnt++;
                }

                if (eggplantColors[0][i].equals(eggplantColors[j][i])) {
                    sameColorColCnt++;
                }
            }

            if (sameColorRowCnt == LENGTH || sameColorColCnt == LENGTH) {
                canMakeEggplantLine = true;
                break;
            }
        }

        sb.append(canMakeEggplantLine ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
