import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int caveCnt = Integer.parseInt(st.nextToken());
        int startCave = Integer.parseInt(st.nextToken());
        int endCave = Integer.parseInt(st.nextToken());

        int[] maxDistance = new int[caveCnt + 1];
        int[] totalDistance = new int[caveCnt + 1];
        totalDistance[startCave] = -1;
        ArrayList<Line>[] lines = new ArrayList[caveCnt + 1];
        for (int i = 0; i <= caveCnt; i++)
            lines[i] = new ArrayList<>();

        for (int i = 0; i < caveCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            lines[a].add(new Line(b, distance));
            lines[b].add(new Line(a, distance));
        }

        Queue<Integer> peaks = new LinkedList<>();
        peaks.add(startCave);
        while (!peaks.isEmpty()) {
            int nowPeak = peaks.poll();

            for (Line nextLine : lines[nowPeak]) {
                int nextPeak = nextLine.getConnectedPeak();
                int distance = nextLine.getDistance();

                if (totalDistance[nextPeak] != 0) {
                    continue;
                }
                totalDistance[nextPeak] += totalDistance[nowPeak] + distance;
                maxDistance[nextPeak] = Math.max(maxDistance[nowPeak], distance);
                peaks.add(nextPeak);
            }
        }
        sb.append(totalDistance[endCave] - maxDistance[endCave] + 1);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Line {
    private int connectedPeak;
    private int distance;

    Line(int connectedPeak, int distance) {
        this.connectedPeak = connectedPeak;
        this.distance = distance;
    }

    public int getConnectedPeak() {
        return this.connectedPeak;
    }

    public int getDistance() {
        return this.distance;
    }
}