import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cowCnt = Integer.parseInt(st.nextToken());
        int maxTime = Integer.parseInt(st.nextToken());
        int[] danceDurationTimes = new int[cowCnt];
        for (int cow = 0; cow < cowCnt; cow++) {
            danceDurationTimes[cow] = Integer.parseInt(br.readLine());
        }

        int minStageCnt = 1, maxStageCnt = cowCnt;
        int ans = 1;
        while (minStageCnt <= maxStageCnt) {
            int stageCnt = (minStageCnt + maxStageCnt) / 2;
            PriorityQueue<Integer> danceDurationTimeOnStages = new PriorityQueue<>();

            for (int cow = 0; cow < cowCnt; cow++) {
                int time = danceDurationTimes[cow];
                if (danceDurationTimeOnStages.size() == stageCnt) {
                    time += danceDurationTimeOnStages.poll();
                }
                danceDurationTimeOnStages.add(time);
            }

            int stageMaxTime = 0;
            while (!danceDurationTimeOnStages.isEmpty()) {
                stageMaxTime = Math.max(stageMaxTime, danceDurationTimeOnStages.poll());
            }

            if (stageMaxTime <= maxTime) {
                maxStageCnt = stageCnt - 1;
                ans = stageCnt;
            } else {
                minStageCnt = stageCnt + 1;
            }
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
