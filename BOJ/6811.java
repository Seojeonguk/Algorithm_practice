import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int troutPoint = Integer.parseInt(br.readLine());
        int pikePoint = Integer.parseInt(br.readLine());
        int pickerelPoint = Integer.parseInt(br.readLine());
        int allowedPoint = Integer.parseInt(br.readLine());

        ArrayList<int[]> possibleCombinations = new ArrayList<>();
        for (int troutCnt = 0; troutCnt * troutPoint <= allowedPoint; troutCnt++) {
            for (int pikeCnt = 0; pikeCnt * pikePoint <= allowedPoint; pikeCnt++) {
                if (troutCnt * troutPoint + pikeCnt * pikePoint > allowedPoint) {
                    break;
                }
                for (int pickerelCnt = 0; pickerelCnt * pickerelPoint <= allowedPoint; pickerelCnt++) {
                    int totalSum = troutCnt * troutPoint + pikeCnt * pikePoint + pickerelCnt * pickerelPoint;
                    if (troutCnt + pikeCnt + pickerelCnt == 0) {
                        continue;
                    }
                    if (totalSum > allowedPoint) {
                        break;
                    }
                    possibleCombinations.add(new int[]{troutCnt, pikeCnt, pickerelCnt});
                }
            }
        }

        for (int[] possibleCombination : possibleCombinations) {
            sb.append(String.format("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n", possibleCombination[0], possibleCombination[1], possibleCombination[2]));
        }
        sb.append("Number of ways to catch fish: ").append(possibleCombinations.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
