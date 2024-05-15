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
            int observedDays = Integer.parseInt(st.nextToken());
            int stress = Integer.parseInt(st.nextToken());
            
            int[] changedStresses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int stressDay = 0;
            int currentStress = 0;
            for (int changedStress : changedStresses) {
                currentStress += changedStress;
                if (currentStress < 0) {
                    currentStress = 0;
                }

                if (currentStress >= stress) {
                    stressDay++;
                }
            }

            sb.append(stressDay);

            bw.write(sb.toString());
        }
    }
}
