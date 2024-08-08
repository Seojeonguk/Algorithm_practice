import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();


            while (true) {
                int ruleCnt = Integer.parseInt(br.readLine());
                if (ruleCnt == 0) {
                    break;
                }

                String[][] rules = new String[ruleCnt][2];
                for (int i = 0; i < ruleCnt; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    rules[i][0] = st.nextToken();
                    rules[i][1] = st.nextToken();
                }

                String start = br.readLine();
                String target = br.readLine();

                sb.append(calMinChange(start, target, rules)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int calMinChange(String start, String target, String[][] rules) {
        int minChange = Integer.MAX_VALUE;

        int targetLength = target.length();

        Queue<Strings> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add(new Strings(start, 0));
        hs.add(start);

        while (!q.isEmpty()) {
            Strings cur = q.poll();

            if (target.equals(cur.str)) {
                minChange = cur.cnt;
                break;
            }

            if (cur.str.length() > targetLength) {
                continue;
            }

            for (int i = 0; i < rules.length; i++) {
                String next = cur.str.replace(rules[i][0], rules[i][1]);
                if (hs.contains(next)) {
                    continue;
                }

                hs.add(next);
                q.add(new Strings(next, cur.cnt + 1));
            }
        }

        return (minChange == Integer.MAX_VALUE ? -1 : minChange);
    }

    static class Strings {
        String str;
        int cnt;

        public Strings(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
