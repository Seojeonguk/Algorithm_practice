import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final String TWIN_BLOB_WIN = ":blob_twintail_aww:";
    static final String PONYTAIL_BLOB_WIN = ":blob_twintail_sad:";
    static final String DRAW = ":blob_twintail_thinking:";
    static int visitCnt = 0;
    static int canVisitCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer twinRoomInfo = new StringTokenizer(br.readLine());
        int depth = Integer.parseInt(twinRoomInfo.nextToken());
        int damagedRoadCnt = Integer.parseInt(twinRoomInfo.nextToken());
        int basicTime = Integer.parseInt(twinRoomInfo.nextToken());
        int addedTime = Integer.parseInt(twinRoomInfo.nextToken());

        boolean[] cantGo = new boolean[(1 << depth)];
        for (int damagedRoadNum = 0; damagedRoadNum < damagedRoadCnt; damagedRoadNum++) {
            StringTokenizer damagedRoadInfo = new StringTokenizer(br.readLine());
            int startDamagedRoad = Integer.parseInt(damagedRoadInfo.nextToken());
            int endDamagedRoad = Integer.parseInt(damagedRoadInfo.nextToken());

            cantGo[endDamagedRoad] = true;
        }

        int twinBlobTime = calTwinBlobTime(cantGo, depth, basicTime, addedTime);
        int ponytailBlobTime = calPonytailBlobTime(cantGo, depth, basicTime, 1, 1);

        if (twinBlobTime < ponytailBlobTime) {
            sb.append(TWIN_BLOB_WIN);
        } else if (twinBlobTime > ponytailBlobTime) {
            sb.append(PONYTAIL_BLOB_WIN);
        } else {
            sb.append(DRAW);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calPonytailBlobTime(boolean[] cantGo, int depth, int basicTime, int curDepth, int curIdx) {
        visitCnt++;

        if (depth == curDepth) {
            return (curIdx == 1 ? 0 : basicTime);
        }

        int time = (curIdx == 1 ? 0 : basicTime);
        
        if (!cantGo[curIdx * 2]) {
            time += calPonytailBlobTime(cantGo, depth, basicTime, curDepth + 1, curIdx * 2);
            if (visitCnt != canVisitCnt) {
                time += basicTime;
            }
        }

        if (!cantGo[curIdx * 2 + 1]) {
            time += calPonytailBlobTime(cantGo, depth, basicTime, curDepth + 1, curIdx * 2 + 1);
            if (visitCnt != canVisitCnt) {
                time += basicTime;
            }
        }

        return time;
    }

    public static int calTwinBlobTime(boolean[] cantGo, int depth, int basicTime, int addedTime) {
        int[] times = new int[cantGo.length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, basicTime, 1});

        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            canVisitCnt++;
            time = Math.max(time, times[cur[0]]);

            int curIdx = cur[0];
            int curTime = cur[1];
            int curDepth = cur[2];
            if (curDepth == depth || (cantGo[curIdx * 2] && cantGo[curIdx * 2 + 1])) {
                continue;
            }

            if (!cantGo[curIdx * 2] && !cantGo[curIdx * 2 + 1]) {
                times[curIdx * 2] = times[curIdx] + curTime + addedTime;
                q.add(new int[]{curIdx * 2, curTime + addedTime, curDepth + 1});
                times[curIdx * 2 + 1] = times[curIdx] + curTime + addedTime;
                q.add(new int[]{curIdx * 2 + 1, curTime + addedTime, curDepth + 1});
            } else if (!cantGo[curIdx * 2]) {
                times[curIdx * 2] = times[curIdx] + curTime;
                q.add(new int[]{curIdx * 2, curTime, curDepth + 1});
            } else {
                times[curIdx * 2 + 1] = times[curIdx] + curTime;
                q.add(new int[]{curIdx * 2 + 1, curTime, curDepth + 1});
            }
        }

        return time;
    }
}
