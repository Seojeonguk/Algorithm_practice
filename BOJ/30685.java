import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int butterCnt = Integer.parseInt(br.readLine());

        Butter[] butters = new Butter[butterCnt];
        for (int i = 0; i < butterCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            butters[i] = new Butter(x, h);
        }

        Arrays.sort(butters);

        sb.append(isForever(butters) ? "forever" : calMaxHeattingTime(butters));

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isForever(Butter[] butters) {
        int notConflictCnt = 0;
        for (int idx = 0; idx < butters.length - 1; idx++) {
            int currentMaxIdx = butters[idx].x + butters[idx].h / 2;
            int nextMinIdx = butters[idx + 1].x - butters[idx + 1].h / 2;

            if (currentMaxIdx < nextMinIdx) {
                notConflictCnt++;
            }
        }

        return notConflictCnt == butters.length - 1;
    }

    public static int calMaxHeattingTime(Butter[] butters) {
        int l = 0, r = Integer.MAX_VALUE - 2;

        while (l < r) {
            int m = (l + r) / 2;

            int notConflictCnt = 0;
            for (int idx = 0; idx < butters.length - 1; idx++) {
                int currentMaxIdx = butters[idx].x + Math.min(butters[idx].h / 2, m);
                int nextMinIdx = butters[idx + 1].x - Math.min(butters[idx + 1].h / 2, m);

                if (currentMaxIdx < nextMinIdx) {
                    notConflictCnt++;
                }
            }

            if (notConflictCnt == butters.length - 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r - 1;
    }

    public static class Butter implements Comparable<Butter> {
        int x;
        int h;

        public Butter(int x, int h) {
            this.x = x;
            this.h = h;
        }


        @Override
        public int compareTo(Butter o) {
            return this.x - o.x;
        }
    }
}
