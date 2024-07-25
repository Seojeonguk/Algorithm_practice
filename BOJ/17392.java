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
            int promiseCnt = Integer.parseInt(st.nextToken());
            int vacationDays = Integer.parseInt(st.nextToken());

            StringTokenizer happiness = new StringTokenizer(br.readLine());
            int[] expectedHappiness = new int[promiseCnt];
            for (int i = 0; i < promiseCnt; i++) {
                expectedHappiness[i] = Integer.parseInt(happiness.nextToken());
            }

            sb.append(calMinDepressed(promiseCnt, expectedHappiness, vacationDays));

            bw.write(sb.toString());
        }
    }

    public static int calMinDepressed(int promiseCnt, int[] expectedHappiness, int vacationDays) {
        int totalHappiness = Arrays.stream(expectedHappiness).sum() + promiseCnt;
        if (totalHappiness >= vacationDays) {
            return 0;
        }

        int left = vacationDays - totalHappiness;

        int[] temp = new int[promiseCnt + 1];
        do {
            for (int i = 0; i < promiseCnt + 1; i++) {
                if (left <= 0) {
                    break;
                }
                temp[i]++;
                left--;
            }
        } while (left > 0);

        int depressed = 0;
        for (int i = 0; i < promiseCnt + 1; i++) {
            for (int j = 1; j <= temp[i]; j++) {
                depressed += j * j;
            }
        }

        return depressed;
    }
}
