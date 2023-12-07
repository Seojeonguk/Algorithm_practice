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

    static final int MAX_FRIEND_COUNT = 9999;

    public static void main(String[] args) throws Exception {
        int studentCnt = Integer.parseInt(br.readLine());
        int[] friendships = new int[MAX_FRIEND_COUNT + 1];

        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());

            friendships[friendA] = friendB;
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());

            if (friendA == 0 && friendB == 0) {
                break;
            }

            int friendSeparation = calFriendSeparation(friendships, friendA, friendB);
            if (friendSeparation >= 0) {
                sb.append("Yes").append(" ").append(friendSeparation).append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calFriendSeparation(int[] friendships, int startFriend, int findFriend) {
        int ret = -1;
        boolean[] visited = new boolean[MAX_FRIEND_COUNT + 1];
        int currentFriend = startFriend;
        int separation = -1;
        while (!visited[currentFriend]) {
            visited[currentFriend] = true;
            if (currentFriend == findFriend) {
                ret = separation;
            }
            currentFriend = friendships[currentFriend];
            separation++;
        }

        if (currentFriend != startFriend) {
            ret = -1;
        }

        return ret;
    }
}
