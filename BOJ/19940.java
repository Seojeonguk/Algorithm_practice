import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    final static int[] BUTTONS = {60, 10, -10, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] fastestMinBtnClicks = calFastestMinBtnClicks();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int destinationTime = Integer.parseInt(br.readLine());

            int addHCnt = destinationTime / 60;
            int remainderTime = destinationTime % 60;

            for (int i = 0; i < BUTTONS.length; i++) {
                sb.append(fastestMinBtnClicks[remainderTime][i] + (i == 0 ? addHCnt : 0)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[][] calFastestMinBtnClicks() {
        int maxAddedTime = Arrays.stream(BUTTONS).max().getAsInt();

        int[][] fastestMinBtnClicks = new int[maxAddedTime + 1][BUTTONS.length];
        boolean[] visited = new boolean[maxAddedTime + 1];
        PriorityQueue<Oven> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.totalBtnClickCnt == o2.totalBtnClickCnt) {
                for (int i = BUTTONS.length - 1; i >= 0; i--) {
                    int a = o1.btnClickCounts[i];
                    int b = o2.btnClickCounts[i];
                    if (a != b) {
                        return Integer.compare(a, b);
                    }
                }
            }
            return Integer.compare(o1.totalBtnClickCnt, o2.totalBtnClickCnt);
        });

        visited[0] = true;
        pq.add(new Oven(BUTTONS.length));
        while (!pq.isEmpty()) {
            Oven cur = pq.poll();

            sameLengthArrayCopy(cur.btnClickCounts, fastestMinBtnClicks[cur.time]);

            for (int i = BUTTONS.length - 1; i >= 0; i--) {
                int nextTime = cur.time + BUTTONS[i];
                if (0 > nextTime || maxAddedTime < nextTime || visited[nextTime]) {
                    continue;
                }

                visited[nextTime] = true;
                int[] nextBtnClickCounts = new int[cur.btnClickCounts.length];

                sameLengthArrayCopy(cur.btnClickCounts, nextBtnClickCounts);
                nextBtnClickCounts[i]++;

                pq.add(new Oven(nextTime, nextBtnClickCounts, cur.totalBtnClickCnt + 1));
            }
        }

        return fastestMinBtnClicks;
    }

    static final void sameLengthArrayCopy(int[] a, int[] b) {
        System.arraycopy(a, 0, b, 0, a.length);
    }

    static class Oven {
        int time;
        int[] btnClickCounts;
        int totalBtnClickCnt;

        Oven(int btnCnt) {
            this.time = 0;
            this.btnClickCounts = new int[btnCnt];
            this.totalBtnClickCnt = 0;
        }

        Oven(int time, int[] btnClickCounts, int totalBtnClickCnt) {
            this.time = time;
            this.btnClickCounts = btnClickCounts;
            this.totalBtnClickCnt = totalBtnClickCnt;
        }
    }
}
