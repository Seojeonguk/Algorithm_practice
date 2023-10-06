import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int teethCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] teeths = new long[teethCnt];
        Set<Long> teethPlaces = new TreeSet<>();
        for (int idx = 0; idx < teethCnt; idx++) {
            teeths[idx] = Long.parseLong(st.nextToken());
            teethPlaces.add(teeths[idx]);
        }
        ArrayList<Long> ans = new ArrayList<>();

        for (int idx = 1; idx <= teethCnt / 2; idx++) {
            long diff = teeths[idx] - teeths[0];
            Set<Long> diffTeeth = new TreeSet<>();

            for (int i = 0; i < teethCnt; i++) {
                long x = teeths[i];
                long xk = teeths[i] + diff;

                if (xk > teeths[teethCnt - 1]) {
                    break;
                }

                if (teethPlaces.contains(x) && teethPlaces.contains(xk)) {
                    diffTeeth.add(x);
                    diffTeeth.add(xk);
                }
            }

            if (diffTeeth.size() == teethCnt) {
                ans.add(diff);
            }
        }

        sb.append(ans.size()).append("\n");
        Collections.sort(ans);
        for (long v : ans) {
            sb.append(v).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
