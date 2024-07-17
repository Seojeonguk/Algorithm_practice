import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    static final Map<Character, Integer> HONOR_POINTS = Map.of(
            'A', 4,
            'K', 3,
            'Q', 2,
            'J', 1
    );

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int tasks = Integer.parseInt(br.readLine());
            int totalHonorPoints = 0;
            for (int task = 0; task < tasks; task++) {
                char[] cards = br.readLine().toCharArray();
                totalHonorPoints += calHonorPoints(cards);
            }

            sb.append(totalHonorPoints).append("\n");

            bw.write(sb.toString());
        }
    }

    public static int calHonorPoints(char[] cards) {
        int honorPoints = 0;

        for (char card : cards) {
            honorPoints += HONOR_POINTS.getOrDefault(card, 0);
        }

        return honorPoints;
    }
}
