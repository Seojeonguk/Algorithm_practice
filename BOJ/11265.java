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

        StringTokenizer serviceInfo = new StringTokenizer(br.readLine());
        int partyCnt = Integer.parseInt(serviceInfo.nextToken());
        int customerCnt = Integer.parseInt(serviceInfo.nextToken());

        int[][] minDistance = new int[partyCnt + 1][partyCnt + 1];
        for (int i = 1; i <= partyCnt; i++) {
            StringTokenizer distanceInfo = new StringTokenizer(br.readLine());
            for (int j = 1; j <= partyCnt; j++) {
                minDistance[i][j] = Integer.parseInt(distanceInfo.nextToken());
            }
        }

        for (int k = 1; k <= partyCnt; k++) {
            for (int i = 1; i <= partyCnt; i++) {
                for (int j = 1; j <= partyCnt; j++) {
                    int sum = minDistance[i][k] + minDistance[k][j];
                    if (minDistance[i][j] > sum) {
                        minDistance[i][j] = sum;
                    }
                }
            }
        }

        for (int customerNum = 1; customerNum <= customerCnt; customerNum++) {
            StringTokenizer customerInfo = new StringTokenizer(br.readLine());
            int customerCurrentParty = Integer.parseInt(customerInfo.nextToken());
            int customerNextParty = Integer.parseInt(customerInfo.nextToken());
            int nextPartyTime = Integer.parseInt(customerInfo.nextToken());

            sb.append(minDistance[customerCurrentParty][customerNextParty] <= nextPartyTime ? "Enjoy other party" : "Stay here").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
