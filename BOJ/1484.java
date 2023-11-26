import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int weight = Integer.parseInt(br.readLine());

        ArrayList<Long> ansList = new ArrayList<>();

        int weightSqrt = (int) Math.sqrt(weight);

        for (long curWeight = weightSqrt; curWeight <= weight; curWeight++) {
            long a = curWeight * curWeight - weight;
            if (a < 0) {
                continue;
            }
            long sqrt = (int) Math.sqrt(a);

            if (sqrt * sqrt == a && sqrt > 0) {
                ansList.add(curWeight);
            }
        }

        if (!ansList.isEmpty()) {
            for (long ans : ansList) {
                sb.append(ans).append("\n");
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
