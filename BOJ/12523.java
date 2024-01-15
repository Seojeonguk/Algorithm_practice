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
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            int totalMonk = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] followedMonks = new ArrayList[totalMonk + 1];
            for (int i = 1; i <= totalMonk; i++) {
                followedMonks[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= totalMonk; i++) {
                int followedMonk = Integer.parseInt(st.nextToken());
                followedMonks[followedMonk].add(i);
            }
            sb.append("Case #").append(testCase).append(":").append("\n");
            for (int i = 1; i <= totalMonk; i++) {
                sb.append(solve(followedMonks, i)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(ArrayList<Integer>[] followedMonks, int startMonk) {
        boolean[] visited = new boolean[followedMonks.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(startMonk);
        visited[startMonk] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int monk = q.poll();
            cnt++;

            for (int nextMonk : followedMonks[monk]) {
                if (visited[nextMonk]) {
                    continue;
                }
                q.add(nextMonk);
            }
        }

        return cnt;
    }
}
