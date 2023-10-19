import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int relationCnt = Integer.parseInt(br.readLine());
            int[] parent = new int[relationCnt * 2 + 1];
            int[] children = new int[relationCnt * 2 + 1];
            for (int idx = 1; idx <= relationCnt * 2; idx++) {
                parent[idx] = idx;
                children[idx] = 1;
            }
            HashMap<String, Integer> friendIndexes = new HashMap<>();
            while (relationCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                String aFriend = st.nextToken();
                String bFriend = st.nextToken();

                int aFriendIdx = getIndex(aFriend, friendIndexes);
                int bFriendIdx = getIndex(bFriend, friendIndexes);

                sb.append(merge(parent, children, aFriendIdx, bFriendIdx)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getIndex(String name, HashMap<String, Integer> friends) {
        int idx = friends.size() + 1;
        if (friends.containsKey(name)) {
            idx = friends.get(name);
        } else {
            friends.put(name, idx);
        }
        return idx;
    }

    public static int find(int[] p, int x) {
        if (p[x] == x) return x;
        return p[x] = find(p, p[x]);
    }

    public static int merge(int[] p, int[] c, int a, int b) {
        a = find(p, a);
        b = find(p, b);

        if (a != b) {
            p[a] = b;
            c[b] += c[a];
        }

        return c[b];
    }
}
