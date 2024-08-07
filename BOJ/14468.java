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

            char[] cows = br.readLine().toCharArray();
            boolean[] isTreated = new boolean[26];
            int[] appeared = new int[26];
            int crossPairs = 0;

            for (int i = 0; i < cows.length; i++) {
                if (isTreated[cows[i] - 'A']) {
                    continue;
                }

                Arrays.fill(appeared, 0);
                for (int j = i + 1; j < cows.length && cows[j] != cows[i]; j++) {
                    int idx = cows[j] - 'A';
                    appeared[idx]++;

                    crossPairs += (appeared[idx] == 1 ? 1 : -1);
                }

                isTreated[cows[i] - 'A'] = true;
            }

            sb.append(crossPairs / 2);

            bw.write(sb.toString());
        }
    }
}
