import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int userCnt = Integer.parseInt(st.nextToken());
        int tierCnt = Integer.parseInt(st.nextToken());

        String[] tierInfos = new String[tierCnt];
        for (int idx = 0; idx < tierCnt; idx++) {
            tierInfos[idx] = br.readLine();
        }

        String friendTierInfo = br.readLine();

        sb.append(getRank(userCnt, tierCnt, tierInfos, friendTierInfo));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String getRank(int userCnt, int tierCnt, String[] tierInfos, String friendTierInfo) {
        long assignedUserCnt = 0;
        long remainingUserCnt = userCnt;
        HashMap<String, long[]> tiers = new HashMap<>();
        for (String tierInfo : tierInfos) {
            String tierName = tierInfo.split(" ")[0];
            String tierPeople = tierInfo.split(" ")[1];

            long assigningUser = 0;
            if (tierPeople.endsWith("%")) {
                long ratio = Long.parseLong(tierPeople.substring(0, tierPeople.indexOf('%')));
                assigningUser = (remainingUserCnt * ratio) / 100;

            } else {
                assigningUser = Long.parseLong(tierPeople);
                assigningUser = Math.min(remainingUserCnt, assigningUser);
            }

            if (assigningUser > 0) {
                tiers.put(tierName, new long[]{assignedUserCnt + 1, assigningUser});
            }

            assignedUserCnt += assigningUser;
            remainingUserCnt -= assigningUser;
        }

        if (assignedUserCnt != userCnt) {
            return "Invalid System";
        }

        boolean isFriendTierDetails = Character.isDigit(friendTierInfo.charAt(friendTierInfo.length() - 1));
        String friendTier = friendTierInfo;
        int tierDetail = -1;
        if (isFriendTierDetails) {
            friendTier = friendTierInfo.substring(0, friendTierInfo.length() - 1);
            tierDetail = friendTierInfo.charAt(friendTierInfo.length() - 1) - '0';
        }

        if (!tiers.containsKey(friendTier)) {
            return "Liar";
        }

        long[] infos = tiers.get(friendTier);
        long minRank = infos[0], maxRank = infos[0] + infos[1] - 1;
        if (tierDetail != -1) {
            if (tierDetail > infos[1]) {
                return "Liar";
            }

            long tierPeople = infos[1];
            long maxPeople = (tierPeople + 3) / 4;
            long[] detailPeople = new long[4];
            for (int i = 0; i < 4; i++) {
                detailPeople[i] = Math.min(tierPeople, maxPeople);
                tierPeople -= detailPeople[i];
            }

            for (int i = 0; i < tierDetail - 1; i++)
                minRank += detailPeople[i];

            maxRank = minRank + detailPeople[tierDetail - 1] - 1;
        }

        return String.format("%d %d", minRank, Math.min(userCnt, maxRank));
    }
}
