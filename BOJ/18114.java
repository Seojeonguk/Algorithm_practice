import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int itemCnt = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            StringTokenizer itemInfo = new StringTokenizer(br.readLine());
            int[] itemWeights = new int[itemCnt];
            for (int itemNum = 0; itemNum < itemCnt; itemNum++) {
                itemWeights[itemNum] = Integer.parseInt(itemInfo.nextToken());
            }

            sb.append(isPossibleCombination(weight, itemWeights));

            bw.write(sb.toString());
        }
    }

    public static int isPossibleCombination(int weight, int[] itemWeights) {
        Arrays.sort(itemWeights);

        for (int i = 0; i < itemWeights.length; i++) {
            if (weight < itemWeights[i]) {
                break;
            }

            if (weight == itemWeights[i]) {
                return 1;
            }

            int secondItemIdx = Arrays.binarySearch(itemWeights, weight - itemWeights[i]);
            if (secondItemIdx >= 0 && secondItemIdx != i) {
                return 1;
            }

            for (int j = i + 1; j < itemWeights.length; j++) {
                if (weight < itemWeights[i] + itemWeights[j]) {
                    break;
                }

                int thirdItemIdx = Arrays.binarySearch(itemWeights, weight - itemWeights[i] - itemWeights[j]);
                if (thirdItemIdx >= 0 && thirdItemIdx != i && thirdItemIdx != j) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
