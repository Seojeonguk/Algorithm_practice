import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer treeInfo = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(treeInfo.nextToken());
        int waterAmount = Integer.parseInt(treeInfo.nextToken());

        ArrayList<Integer>[] connectedNodes = new ArrayList[nodeCnt + 1];
        for (int nodeNum = 1; nodeNum <= nodeCnt; nodeNum++) {
            connectedNodes[nodeNum] = new ArrayList<>();
        }

        for (int i = 0; i < nodeCnt - 1; i++) {
            StringTokenizer lineInfo = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(lineInfo.nextToken());
            int nodeB = Integer.parseInt(lineInfo.nextToken());

            connectedNodes[nodeA].add(nodeB);
            connectedNodes[nodeB].add(nodeA);
        }

        int leafNodeCnt = calLeafNodeCnt(nodeCnt, connectedNodes);
        sb.append(1.0 * waterAmount / leafNodeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calLeafNodeCnt(int nodeCnt, ArrayList<Integer>[] connectedNodes) {
        int leafNodeCnt = 0;

        boolean[] isVisit = new boolean[nodeCnt + 1];
        Queue<Integer> q = new LinkedList<>();

        isVisit[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            boolean isLeafNode = true;

            for (int next : connectedNodes[cur]) {
                if (isVisit[next]) {
                    continue;
                }
                isVisit[next] = true;
                isLeafNode = false;
                q.add(next);
            }

            if (isLeafNode) {
                leafNodeCnt++;
            }
        }

        return leafNodeCnt;
    }
}
