import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arrSize = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        HashMap<Long, Long> parent = new HashMap<>();
        HashMap<Long, Long> nexts = new HashMap<>();

        for (long x : arr) {
            parent.put(x, -1L);
            nexts.put(x, -1L);
        }

        for (long x : arr) {
            if (parent.containsKey(x * 2)) {
                parent.put(x * 2, x);
                nexts.put(x, x * 2);
            }

            if (x % 3 == 0) {
                if (parent.containsKey(x / 3)) {
                    parent.put(x / 3, x);
                    nexts.put(x, x / 3);
                }
            }
        }

        long x = -1;
        for (int i = 0; i < arrSize; i++) {
            if (parent.get(arr[i]) == -1) {
                x = arr[i];
            }
        }

        while (x != -1) {
            sb.append(x).append(" ");
            x = nexts.get(x);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
