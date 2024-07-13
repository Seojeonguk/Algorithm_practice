import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Main {

    static final Map<Character, Integer> INDEXES = Map.of(
            'T', 0,
            'G', 1,
            'F', 2,
            'P', 3
    );

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int roadLength = Integer.parseInt(br.readLine());
            char[] roads = br.readLine().toCharArray();
            int[] sums = new int[4];

            int[][][][] rangeCounts = new int[3][3][3][3];
            rangeCounts[0][0][0][0] = 1;

            int ans = 0;

            for (int i = 0; i < roadLength; i++) {
                int idx = INDEXES.get(roads[i]);
                sums[idx] = (sums[idx] + 1) % 3;

                ans += rangeCounts[sums[0]][sums[1]][sums[2]][sums[3]];
                rangeCounts[sums[0]][sums[1]][sums[2]][sums[3]] += 1;
            }

            sb.append(ans);

            bw.write(sb.toString());
        }
    }
}
