import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    static final int MAX_VALUE = 10000000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            boolean[] isNotPrimes = new boolean[MAX_VALUE];
            isNotPrimes[0] = isNotPrimes[1] = true;
            for (int i = 2; i < MAX_VALUE; i++) {
                if (isNotPrimes[i]) {
                    continue;
                }

                for (int j = i + i; j < MAX_VALUE; j += i) {
                    isNotPrimes[j] = true;
                }
            }

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                char[] wrote = br.readLine().toCharArray();
                HashSet<Integer> hs = new HashSet<>();
                boolean[] selected = new boolean[wrote.length];

                int makePrimeCnt = combination(isNotPrimes, wrote, hs, selected, "");
                sb.append(makePrimeCnt).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int combination(boolean[] isNotPrimes, char[] wrote, HashSet<Integer> hs, boolean[] selected, String cur) {
        int ret = 0;
        if (!cur.isEmpty()) {
            int current = Integer.parseInt(cur);
            if (!hs.contains(current)) {
                hs.add(current);
                if (!isNotPrimes[current]) {
                    ret = 1;
                }
            }
        }

        for (int idx = 0; idx < wrote.length; idx++) {
            if (selected[idx]) {
                continue;
            }

            selected[idx] = true;
            String next = cur + wrote[idx];
            ret += combination(isNotPrimes, wrote, hs, selected, next);
            selected[idx] = false;
        }

        return ret;
    }
}
