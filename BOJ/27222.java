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

            int numDays = Integer.parseInt(br.readLine());
            int[] isTrainingDays = new int[numDays];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numDays; i++) {
                isTrainingDays[i] = Integer.parseInt(st.nextToken());
            }

            int totalMuscleGain = 0;
            for (int i = 0; i < numDays; i++) {
                StringTokenizer weights = new StringTokenizer(br.readLine());
                int beforeTrainingWeight = Integer.parseInt(weights.nextToken());
                int afterTrainingWeight = Integer.parseInt(weights.nextToken());

                int changedWeight = afterTrainingWeight - beforeTrainingWeight;
                if (isTrainingDays[i] == 0 || changedWeight < 0) {
                    changedWeight = 0;
                }

                totalMuscleGain += changedWeight;
            }

            sb.append(totalMuscleGain);

            bw.write(sb.toString());
        }
    }
}
