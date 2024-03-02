import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arrSize = Integer.parseInt(br.readLine());
        int[] targetArrays = new int[arrSize];
        StringTokenizer targetArraysInfo = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < arrSize; idx++) {
            targetArrays[idx] = Integer.parseInt(targetArraysInfo.nextToken());
        }

        int maxTargetArrays = Arrays.stream(targetArrays).max().getAsInt();

        Information[] information = new Information[maxTargetArrays + 1];
        for (int i = 0; i < maxTargetArrays + 1; i++) {
            information[i] = new Information();
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        information[0].visited = true;
        information[0].addCnt = information[0].multipleCnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            int next = cur * 2;
            if (next <= maxTargetArrays && !information[next].visited) {
                information[next].visited = true;
                information[next].addCnt = information[cur].addCnt;
                information[next].multipleCnt = information[cur].multipleCnt + 1;

                q.add(next);
            }

            next = cur + 1;
            if (next <= maxTargetArrays && !information[next].visited) {
                information[next].visited = true;
                information[next].addCnt = information[cur].addCnt + 1;
                information[next].multipleCnt = information[cur].multipleCnt;

                q.add(next);
            }
        }

        int minOperationCnt = 0;
        int maxMultipleCnt = 0;
        for (int idx = 0; idx < arrSize; idx++) {
            Information info = information[targetArrays[idx]];
            minOperationCnt += info.addCnt;
            maxMultipleCnt = Math.max(maxMultipleCnt, info.multipleCnt);

        }
        minOperationCnt += maxMultipleCnt;
        sb.append(minOperationCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Information {
        boolean visited;
        int addCnt, multipleCnt;

        Information() {
            this.visited = false;
            this.addCnt = 0;
            this.multipleCnt = 0;
        }
    }
}
