import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            br.readLine();
            StringTokenizer soldierCntToken = new StringTokenizer(br.readLine());
            int sejunSoldierCnt = Integer.parseInt(soldierCntToken.nextToken());
            int sebiSoldierCnt = Integer.parseInt(soldierCntToken.nextToken());

            int[] sejunSoldierPowers = new int[sejunSoldierCnt];
            StringTokenizer sejunSoldierPowersToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < sejunSoldierCnt; i++) {
                int sejunSoldierPower = Integer.parseInt(sejunSoldierPowersToken.nextToken());
                sejunSoldierPowers[i] = sejunSoldierPower;
            }

            int[] sebiSoldierPowers = new int[sebiSoldierCnt];
            StringTokenizer sebiSoldierPowersToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < sebiSoldierCnt; i++) {
                int sebiSoldierPower = Integer.parseInt(sebiSoldierPowersToken.nextToken());
                sebiSoldierPowers[i] = sebiSoldierPower;
            }

            Arrays.sort(sejunSoldierPowers);
            Arrays.sort(sebiSoldierPowers);

            char result = whosWin(sejunSoldierPowers, sebiSoldierPowers);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char whosWin(int[] sejunSoldierPowers, int[] sebiSoldierPowers) {
        int sejunIdx = 0, sebiIdx = 0;
        while (sejunIdx != sejunSoldierPowers.length && sebiIdx != sebiSoldierPowers.length) {
            int sejunMinSoldierPower = sejunSoldierPowers[sejunIdx];
            int sebiMinSoldierPower = sebiSoldierPowers[sebiIdx];

            if (sebiMinSoldierPower > sejunMinSoldierPower) {
                sejunIdx++;
            } else {
                sebiIdx++;
            }
        }
        return (sejunIdx == sejunSoldierPowers.length ? 'B' : 'S');
    }
}
