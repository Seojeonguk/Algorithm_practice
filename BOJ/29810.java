import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int factionalBetrayerFriendCnt = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int friendCnt = Integer.parseInt(st.nextToken());
        int relationshipInfoCnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] friends = new ArrayList[friendCnt + 1];
        for (int i = 0; i <= friendCnt; i++) {
            friends[i] = new ArrayList<>();
        }
        while (relationshipInfoCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());
            friends[friendA].add(friendB);
            friends[friendB].add(friendA);
        }
        int betrayer = Integer.parseInt(br.readLine());
        boolean[] isVisit = new boolean[friendCnt + 1];
        isVisit[betrayer] = true;
        int maxFactionalSize = 0;
        for (int friend = 1; friend <= friendCnt; friend++) {
            if (!isVisit[friend]) {
                factionalBetrayerFriendCnt = 0;
                isVisit[friend] = true;
                int factionalSize = getFactionalSize(friends, isVisit, friend, betrayer);

                if (factionalBetrayerFriendCnt == 1) {
                    factionalSize++;
                }
                maxFactionalSize = Math.max(maxFactionalSize, factionalSize);
            }
        }
        sb.append(maxFactionalSize);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getFactionalSize(ArrayList<Integer>[] friends, boolean[] isVisit, int currentFriend, int betrayer) {
        int ret = 1;
        for (int nextFriend : friends[currentFriend]) {
            if (nextFriend == betrayer) {
                factionalBetrayerFriendCnt++;
            }
            if (!isVisit[nextFriend]) {
                isVisit[nextFriend] = true;
                ret += getFactionalSize(friends, isVisit, nextFriend, betrayer);
            }
        }
        return ret;
    }
}
