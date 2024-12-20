import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[] PLATE_COSTS = {3, 4, 5};
    static final int PLATE_TYPE_COUNT = 3;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[] chosenPlates = new int[PLATE_TYPE_COUNT];
            for (int i = 0; i < PLATE_TYPE_COUNT; i++) {
                chosenPlates[i] = Integer.parseInt(br.readLine());
            }

            sb.append(calCosts(chosenPlates));

            bw.write(sb.toString());
        }
    }

    public static int calCosts(int[] chosenPlates) {
        int cost = 0;

        for (int idx = 0; idx < chosenPlates.length; idx++) {
            cost += chosenPlates[idx] * PLATE_COSTS[idx];
        }

        return cost;
    }
}
