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

            int animalNum = Integer.parseInt(br.readLine());

            String[] species = new String[animalNum];
            int[] influences = new int[animalNum];

            int maxPigInfluence = 0;

            for (int i = 0; i < animalNum; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String speciesName = st.nextToken();
                int influence = Integer.parseInt(st.nextToken());

                species[i] = speciesName;
                influences[i] = influence;

                if (species[i].equals("pig")) {
                    maxPigInfluence = Math.max(maxPigInfluence, influence);
                }
            }

            long maxInfluenceSum = maxPigInfluence;
            for (int i = 0; i < animalNum; i++) {
                if (!species[i].equals("pig") && influences[i] < maxPigInfluence) {
                    maxInfluenceSum += influences[i];
                }
            }

            sb.append(maxInfluenceSum);

            bw.write(sb.toString());
        }
    }
}
