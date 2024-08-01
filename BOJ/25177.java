import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentFacilityCnt = Integer.parseInt(st.nextToken());
            int pastFacilityCnt = Integer.parseInt(st.nextToken());

            int maxFacilityCnt = Math.max(currentFacilityCnt, pastFacilityCnt);

            int[] currentFacilityScores = new int[maxFacilityCnt];
            StringTokenizer currentFacilityScoresToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < currentFacilityCnt; i++) {
                currentFacilityScores[i] = Integer.parseInt(currentFacilityScoresToken.nextToken());
            }

            int[] pastFacilityScores = new int[maxFacilityCnt];
            StringTokenizer pastFacilityScoresToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < pastFacilityCnt; i++) {
                pastFacilityScores[i] = Integer.parseInt(pastFacilityScoresToken.nextToken());
            }

            int maxIncreaseScore = 0;
            for (int i = 0; i < maxFacilityCnt; i++) {
                maxIncreaseScore = Math.max(maxIncreaseScore, Math.max(0, pastFacilityScores[i] - currentFacilityScores[i]));
            }

            sb.append(maxIncreaseScore);

            bw.write(sb.toString());
        }
    }
}
