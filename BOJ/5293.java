import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCnt = Integer.parseInt(st.nextToken());
        int pirateCnt = Integer.parseInt(st.nextToken());

        int pileCoinCnt = coinCnt;
        int[] keepCoins = new int[pirateCnt];
        for (int i = 0; i < pirateCnt; i++) {
            int remainderCoin = pileCoinCnt % pirateCnt;
            int divideCoin = pileCoinCnt / pirateCnt;

            keepCoins[i] = divideCoin + remainderCoin;
            pileCoinCnt -= keepCoins[i];
            sb.append(keepCoins[i]).append(" ");
        }

        sb.append("\n").append(pileCoinCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
