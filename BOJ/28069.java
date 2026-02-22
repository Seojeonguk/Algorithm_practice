import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final String CAN_EAT_MINI_GIMBAP = "minigimbob";
    static final String CAN_NOT_EAT_MINI_GIMBAP = "water";

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stairsCnt = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[stairsCnt + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        boolean canEat = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int currentIdx = cur[0];
            int movedCnt = cur[1];

            if (currentIdx == stairsCnt) {
                canEat = true;
                break;
            }

            if (movedCnt == commandCnt) {
                continue;
            }

            int next = currentIdx + 1;
            if (next <= stairsCnt && !isVisited[next]) {
                isVisited[next] = true;
                q.add(new int[]{next, movedCnt + 1});
            }

            int useStaffNext = currentIdx + currentIdx / 2;
            if (useStaffNext <= stairsCnt && !isVisited[useStaffNext]) {
                isVisited[useStaffNext] = true;
                q.add(new int[]{useStaffNext, movedCnt + 1});
            }
        }

        sb.append(canEat ? CAN_EAT_MINI_GIMBAP : CAN_NOT_EAT_MINI_GIMBAP);

        bw.write(sb.toString());
        bw.flush();
    }
}
