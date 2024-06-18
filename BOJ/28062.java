import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int bundleCandyCnt = Integer.parseInt(br.readLine());
            int[] bundleCandies = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxHasCandy = 0;
            int minOddCandy = Integer.MAX_VALUE;
            for (int idx = 0; idx < bundleCandyCnt; idx++) {
                maxHasCandy += bundleCandies[idx];
                if (bundleCandies[idx] % 2 == 1) {
                    minOddCandy = Math.min(minOddCandy, bundleCandies[idx]);
                }
            }

            sb.append(maxHasCandy - (maxHasCandy % 2 == 1 ? minOddCandy : 0));

            bw.write(sb.toString());
        }
    }
}
