import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int TOTAL_PIZZA_SLICE = 8;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[] amountMushrooms = new int[TOTAL_PIZZA_SLICE];
            for (int i = 0; i < TOTAL_PIZZA_SLICE; i++) {
                amountMushrooms[i] = Integer.parseInt(br.readLine());
            }

            sb.append(getMaxMushrooms(amountMushrooms));

            bw.write(sb.toString());
        }
    }

    public static int getMaxMushrooms(int[] amountMushrooms) {
        int maxMushrooms = 0;
        for (int i = 0; i < amountMushrooms.length; i++) {
            int mushrooms = amountMushrooms[i]
                    + amountMushrooms[(i + 1) % TOTAL_PIZZA_SLICE]
                    + amountMushrooms[(i + 2) % TOTAL_PIZZA_SLICE]
                    + amountMushrooms[(i + 3) % TOTAL_PIZZA_SLICE];

            maxMushrooms = Math.max(maxMushrooms, mushrooms);
        }

        return maxMushrooms;
    }
}
