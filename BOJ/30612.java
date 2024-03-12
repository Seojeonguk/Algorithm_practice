import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int mountainCnt = Integer.parseInt(br.readLine());
        int[] heights = new int[mountainCnt];

        StringTokenizer heightInfo = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < mountainCnt; idx++) {
            heights[idx] = Integer.parseInt(heightInfo.nextToken());
        }

        long sumLake = calLake(heights);
        sb.append(sumLake);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calLake(int[] heights) {
        long lake = 0;

        Stack<int[]> s = new Stack<>();
        for (int height : heights) {
            if (s.isEmpty()) {
                s.push(new int[]{height, 1});
            } else {
                boolean isConnectedGround = false;
                int cnt = 0;

                while (!s.isEmpty() && s.peek()[0] <= height) {
                    int[] cur = s.pop();

                    if (cur[0] == 0) {
                        isConnectedGround = true;
                    }

                    if (isConnectedGround || s.isEmpty()) {
                        continue;
                    }

                    int prevHeight = s.peek()[0];
                    if (prevHeight == 0) {
                        continue;
                    }

                    cnt += cur[1];
                    lake += (long) (Math.min(prevHeight, height) - cur[0]) * cnt;
                }

                if (isConnectedGround && !s.isEmpty()) {
                    s.push(new int[]{0, 1});
                }

                if (s.isEmpty()) {
                    cnt = 0;
                }

                s.push(new int[]{height, cnt + 1});
            }
        }

        return lake;
    }
}
