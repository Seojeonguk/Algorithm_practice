import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int videoCnt = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] usados = new ArrayList[videoCnt + 1];
        for (int video = 1; video <= videoCnt; video++) {
            usados[video] = new ArrayList<>();
        }

        for (int i = 0; i < videoCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int firstVideo = Integer.parseInt(st.nextToken());
            int secondVideo = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            usados[firstVideo].add(new int[]{secondVideo, cost});
            usados[secondVideo].add(new int[]{firstVideo, cost});
        }

        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int minUsado = Integer.parseInt(st.nextToken());
            int watchingVideo = Integer.parseInt(st.nextToken());

            int recommendedVideoCnt = getRecommendedVideoCnt(usados, minUsado, watchingVideo);
            sb.append(recommendedVideoCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getRecommendedVideoCnt(ArrayList<int[]>[] usados, int minUsado, int watchingVideo) {
        int recommendedVideoCnt = 0;

        boolean[] visited = new boolean[usados.length];
        Queue<int[]> q = new LinkedList<>();
        visited[watchingVideo] = true;
        q.add(new int[]{watchingVideo, Integer.MAX_VALUE});

        while (!q.isEmpty()) {
            int curVideo = q.peek()[0];
            int curCost = q.peek()[1];
            q.poll();

            if (curCost >= minUsado && curCost != Integer.MAX_VALUE) {
                recommendedVideoCnt++;
            }

            for (int idx = 0; idx < usados[curVideo].size(); idx++) {
                int nextVideo = usados[curVideo].get(idx)[0];
                int nextCost = usados[curVideo].get(idx)[1];

                if (visited[nextVideo]) {
                    continue;
                }
                visited[nextVideo] = true;
                q.add(new int[]{nextVideo, Math.min(curCost, nextCost)});
            }
        }

        return recommendedVideoCnt;
    }
}
