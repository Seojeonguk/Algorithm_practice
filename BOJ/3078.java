import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Queue<Integer>[] q = new Queue[21];
        for (int i = 2; i <= 20; i++) {
            q[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        int totalStudent = Integer.parseInt(st.nextToken());
        int goodFriendRange = Integer.parseInt(st.nextToken());

        long goodFriend = 0;
        for (int i = 0; i < totalStudent; i++) {
            int studentLength = br.readLine().length();
            while (!q[studentLength].isEmpty()) {
                if (q[studentLength].peek() + goodFriendRange < i) {
                    q[studentLength].poll();
                } else {
                    break;
                }
            }
            goodFriend += q[studentLength].size();
            q[studentLength].add(i);
        }

        sb.append(goodFriend);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
