import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int arrSize = Integer.parseInt(br.readLine());

            int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maxDistance = 0;

            for (int i = 0; i < x.length; i++) {
                for (int j = i; j < y.length; j++) {
                    if (x[i] <= y[j]) {
                        maxDistance = Math.max(maxDistance, j - i);
                    }
                }
            }

            sb.append(String.format("The maximum distance is %d\n\n", maxDistance));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
