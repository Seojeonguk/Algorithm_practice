import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX_SHIP_CARGO_CAPACITY = 10000000;
    static List<Integer> weights = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int weight = 1; weight <= MAX_SHIP_CARGO_CAPACITY; weight *= 3) {
            weights.add(weight);
        }

        for (int tc = 0; tc < testCase; tc++) {
            int shipCapacity = Integer.parseInt(br.readLine());

            int idx = 0;
            while (idx < weights.size()) {
                if (weights.get(idx) > shipCapacity) {
                    break;
                }
                idx++;
            }
            idx--;

            while (idx > -1) {
                sb.append(String.format("%d ", shipCapacity / weights.get(idx)));
                shipCapacity %= weights.get(idx);
                idx--;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
