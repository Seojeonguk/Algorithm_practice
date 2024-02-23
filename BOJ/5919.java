import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int pileCnt = Integer.parseInt(br.readLine());
        int[] piles = new int[pileCnt];
        int totalPile = 0;
        for (int pileNum = 0; pileNum < pileCnt; pileNum++) {
            piles[pileNum] = Integer.parseInt(br.readLine());
            totalPile += piles[pileNum];
        }

        int minMovingPile = 0;
        int pileAvg = totalPile / pileCnt;
        for (int pileNum = 0; pileNum < pileCnt; pileNum++) {
            minMovingPile += (pileAvg < piles[pileNum] ? piles[pileNum] - pileAvg : 0);
        }

        sb.append(minMovingPile);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
