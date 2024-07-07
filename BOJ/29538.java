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
            int airplaneWeight = Integer.parseInt(st.nextToken());
            int totalPeopleOnBoard = Integer.parseInt(st.nextToken());
            int requiredFuelAmountPerTon = Integer.parseInt(st.nextToken());

            int sumWeight = airplaneWeight;

            int[] peopleWeights = new int[totalPeopleOnBoard];
            StringTokenizer weights = new StringTokenizer(br.readLine());
            for (int i = 0; i < totalPeopleOnBoard; i++) {
                peopleWeights[i] = Integer.parseInt(weights.nextToken());
                sumWeight += peopleWeights[i];
            }

            if (requiredFuelAmountPerTon >= 1000) {
                sb.append("Impossible");
            } else {
                double res = (sumWeight * requiredFuelAmountPerTon) / (1000.0 - requiredFuelAmountPerTon);
                sb.append(res);
            }

            bw.write(sb.toString());
        }
    }
}
