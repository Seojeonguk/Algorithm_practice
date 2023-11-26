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
        st = new StringTokenizer(br.readLine());
        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        String ans = getAns(s, t);

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String getAns(long s, long t) {
        if (s == t) return "0";

        String ans = "-1";
        HashSet<Long> hs = new HashSet<>();
        Queue<Data> q = new LinkedList<>();
        hs.add(s);
        q.add(new Data(s, ""));

        while (!q.isEmpty()) {
            Data cur = q.poll();

            if (cur.value == t) {
                ans = cur.str;
                break;
            }

            long nextValue = cur.value * cur.value;
            if (!hs.contains(nextValue) && nextValue <= t) {
                hs.add(nextValue);
                q.add(new Data(nextValue, cur.str + "*"));
            }

            nextValue = cur.value + cur.value;
            if (!hs.contains(nextValue) && nextValue <= t) {
                hs.add(nextValue);
                q.add(new Data(nextValue, cur.str + "+"));
            }

            nextValue = cur.value - cur.value;
            if (!hs.contains(nextValue) && nextValue <= t) {
                hs.add(nextValue);
                q.add(new Data(nextValue, cur.str + "-"));
            }

            if (cur.value != 0) {
                nextValue = cur.value / cur.value;
                if (!hs.contains(nextValue) && nextValue <= t) {
                    hs.add(nextValue);
                    q.add(new Data(nextValue, cur.str + "/"));
                }
            }
        }

        return ans;
    }

    static class Data {
        long value;
        String str;

        Data(long value, String str) {
            this.value = value;
            this.str = str;
        }
    }
}
