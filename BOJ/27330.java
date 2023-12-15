import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalRound = Integer.parseInt(br.readLine());
        int[] roundScores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int totalAvoidScore = Integer.parseInt(br.readLine());
        Set<Integer> avoidScores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        int currentScore = 0;
        for (int i = 0; i < totalRound; i++) {
            currentScore += roundScores[i];
            if (avoidScores.contains(currentScore)) {
                currentScore = 0;
            }
        }

        sb.append(currentScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
