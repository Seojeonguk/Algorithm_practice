import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int blockCnt = Integer.parseInt(st.nextToken());
            int supportIceCnt = Integer.parseInt(st.nextToken());
            int penguinStartBlock = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] connectedBlocks = new ArrayList[blockCnt + 1];
            for (int blockNum = 1; blockNum <= blockCnt; blockNum++) {
                connectedBlocks[blockNum] = new ArrayList<>();
            }

            for (int i = 0; i < blockCnt - 1; i++) {
                StringTokenizer connectedBlockInfo = new StringTokenizer(br.readLine());
                int aBlock = Integer.parseInt(connectedBlockInfo.nextToken());
                int bBlock = Integer.parseInt(connectedBlockInfo.nextToken());

                connectedBlocks[aBlock].add(bBlock);
                connectedBlocks[bBlock].add(aBlock);
            }

            ArrayList<Integer> minDistanceFromSupportIce = calDistanceFromSupportIce(supportIceCnt, penguinStartBlock, connectedBlocks);
            Collections.sort(minDistanceFromSupportIce);

            int maxBreakingIce = blockCnt - minDistanceFromSupportIce.get(0) - minDistanceFromSupportIce.get(1) - 1;
            sb.append(maxBreakingIce);

            bw.write(sb.toString());
        }
    }

    public static ArrayList<Integer> calDistanceFromSupportIce(int supportIceCnt, int penguinStartIce, ArrayList<Integer>[] connectedBlocks) {
        ArrayList<Integer> minDistanceFromSupportIce = new ArrayList<>();

        boolean[] isVisited = new boolean[connectedBlocks.length];

        Queue<int[]> q = new LinkedList<>();
        isVisited[penguinStartIce] = true;
        q.add(new int[]{penguinStartIce, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] <= supportIceCnt) {
                minDistanceFromSupportIce.add(cur[1]);
            }

            for (int nextIce : connectedBlocks[cur[0]]) {
                if (isVisited[nextIce]) {
                    continue;
                }

                isVisited[nextIce] = true;
                q.add(new int[]{nextIce, cur[1] + 1});
            }
        }

        return minDistanceFromSupportIce;
    }
}
