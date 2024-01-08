import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalPlayer = Integer.parseInt(br.readLine());
        Player[] players = new Player[totalPlayer];

        TreeMap<Integer, Integer> playerIndexes = new TreeMap<>();
        for (int i = 0; i < totalPlayer; i++) {
            int ability = Integer.parseInt(br.readLine());
            players[i] = new Player(ability, i);
            playerIndexes.put(ability, i);
        }

        Arrays.sort(players, Comparator.comparingInt(o -> o.ability));
        int[] ranks = new int[totalPlayer];
        for (int i = 0; i < totalPlayer; i++) {
            Player player = players[i];
            ranks[playerIndexes.get(player.ability)] = i;
        }

        Seg seg = new Seg(totalPlayer * 4);
        for (int i = 0; i < totalPlayer; i++) {
            int bestRank = seg.query(ranks[i], totalPlayer - 1, 0, totalPlayer - 1, 1);
            sb.append(bestRank + 1).append("\n");
            seg.update(ranks[i], 1, 0, totalPlayer - 1, 1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Player {
        int ability, idx;

        Player(int ability, int idx) {
            this.ability = ability;
            this.idx = idx;
        }
    }

    static class Seg {
        int[] tree;

        Seg(int size) {
            tree = new int[size];
        }

        int query(int l, int r, int nL, int nR, int node) {
            if (nR < l || nL > r) {
                return 0;
            }
            if (l <= nL && nR <= r) {
                return tree[node];
            }
            int mid = (nL + nR) / 2;

            return query(l, r, nL, mid, node * 2) + query(l, r, mid + 1, nR, node * 2 + 1);
        }

        int update(int pos, int value, int l, int r, int node) {
            if (pos < l || r < pos) {
                return tree[node];
            }
            if (l == r) {
                return tree[node] += value;
            }

            int mid = (l + r) / 2;
            int left = update(pos, value, l, mid, node * 2);
            int right = update(pos, value, mid + 1, r, node * 2 + 1);

            return tree[node] = (left + right);
        }
    }
}
