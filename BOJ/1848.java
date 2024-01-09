import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int totalRoom = Integer.parseInt(st.nextToken());
        int totalTunnel = Integer.parseInt(st.nextToken());

        ArrayList<Tunnel>[] tunnels = new ArrayList[totalRoom + 1];
        ArrayList<Data>[] vec = new ArrayList[totalRoom + 1];
        for (int i = 0; i <= totalRoom; i++) {
            tunnels[i] = new ArrayList<>();
            vec[i] = new ArrayList<>();
        }

        for (int i = 0; i < totalTunnel; i++) {
            st = new StringTokenizer(br.readLine());
            int roomA = Integer.parseInt(st.nextToken());
            int roomB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int reverseCost = Integer.parseInt(st.nextToken());

            tunnels[roomA].add(new Tunnel(roomB, cost));
            tunnels[roomB].add(new Tunnel(roomA, reverseCost));
        }

        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        for (Tunnel tunnel : tunnels[1]) {
            pq.add(new Data(tunnel.roomNum, tunnel.roomNum, tunnel.tunnelCost));
        }

        long ans = Long.MAX_VALUE;
        while (!pq.isEmpty()) {
            Data now = pq.poll();
            int x = now.roomNum;
            if (vec[now.roomNum].size() >= 2 || (vec[now.roomNum].size() == 1 && vec[now.roomNum].get(0).startRoomNum == now.startRoomNum)) {
                continue;
            }
            vec[now.roomNum].add(now);
            for (Tunnel tunnel : tunnels[x]) {
                if (tunnel.roomNum == 1) {
                    if (now.roomNum != now.startRoomNum) {
                        ans = Math.min(ans, now.cost + tunnel.tunnelCost);
                    }
                    continue;
                }
                pq.add(new Data(tunnel.roomNum, now.startRoomNum, now.cost + tunnel.tunnelCost));
            }
        }

        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Tunnel {
        int roomNum, tunnelCost;

        Tunnel(int roomNum, int tunnelCost) {
            this.roomNum = roomNum;
            this.tunnelCost = tunnelCost;
        }
    }

    static class Data {
        int roomNum, startRoomNum;
        long cost;

        Data(int roomNum, int startRoomNum, long cost) {
            this.roomNum = roomNum;
            this.startRoomNum = startRoomNum;
            this.cost = cost;
        }
    }
}
