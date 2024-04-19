import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int personCnt = Integer.parseInt(st.nextToken());
            int relationshipCnt = Integer.parseInt(st.nextToken());

            boolean[][] isFriend = new boolean[personCnt + 1][personCnt + 1];
            int[] friends = new int[personCnt + 1];

            for (int i = 0; i < relationshipCnt; i++) {
                StringTokenizer friendInfo = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(friendInfo.nextToken());
                int b = Integer.parseInt(friendInfo.nextToken());

                isFriend[a][b] = true;
                isFriend[b][a] = true;
                friends[a]++;
                friends[b]++;
            }

            int minThreeFriends = Integer.MAX_VALUE;
            for (int i = 1; i <= personCnt; i++) {
                for (int j = i + 1; j <= personCnt; j++) {
                    if (!isFriend[i][j]) {
                        continue;
                    }

                    for (int k = j + 1; k <= personCnt; k++) {
                        if (!isFriend[i][k] || !isFriend[j][k]) {
                            continue;
                        }

                        minThreeFriends = Math.min(minThreeFriends, friends[i] + friends[j] + friends[k] - 6);
                    }
                }
            }

            sb.append(minThreeFriends == Integer.MAX_VALUE ? -1 : minThreeFriends);

            bw.write(sb.toString());
        }
    }
}
