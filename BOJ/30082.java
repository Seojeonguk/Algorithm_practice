import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer friendInfo = new StringTokenizer(br.readLine());
        int friendCnt = Integer.parseInt(friendInfo.nextToken());
        int bestFriendCnt = Integer.parseInt(friendInfo.nextToken());
        int relationCnt = Integer.parseInt(friendInfo.nextToken());

        boolean[] isVisit = new boolean[friendCnt + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < bestFriendCnt; i++) {
            int bestFriend = Integer.parseInt(br.readLine());
            isVisit[bestFriend] = true;
            q.add(bestFriend);
        }

        ArrayList<Integer>[] friendRelations = new ArrayList[friendCnt + 1];
        for (int i = 1; i <= friendCnt; i++) {
            friendRelations[i] = new ArrayList<>();
        }

        for (int i = 0; i < relationCnt; i++) {
            StringTokenizer knowingFriend = new StringTokenizer(br.readLine());
            int aFriend = Integer.parseInt(knowingFriend.nextToken());
            int bFriend = Integer.parseInt(knowingFriend.nextToken());

            friendRelations[aFriend].add(bFriend);
            friendRelations[bFriend].add(aFriend);
        }

        int requiredCard = 0;
        while (!q.isEmpty()) {
            int friendNum = q.poll();

            requiredCard++;

            for (int knowingFriendNum : friendRelations[friendNum]) {
                if (isVisit[knowingFriendNum]) {
                    continue;
                }
                isVisit[knowingFriendNum] = true;
                q.add(knowingFriendNum);
            }
        }

        sb.append(requiredCard);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
