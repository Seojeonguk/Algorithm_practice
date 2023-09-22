import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int DAYS = 7;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int friendCnt = Integer.parseInt(st.nextToken());
        int weeks = Integer.parseInt(st.nextToken());
        char[][] streak = new char[DAYS][weeks];
        Friend[] friends = new Friend[friendCnt];
        for (int idx = 0; idx < friendCnt; idx++) {
            String name = br.readLine();
            for (int d = 0; d < DAYS; d++) {
                streak[d] = br.readLine().toCharArray();
            }

            int maxStreak = 0, minStreakFreezeInMaxStreak = 0, maxStreakStartDay = 0, streakFail = 0;
            int currentStreak = 0, currentUseStreakFreezeCnt = 0, currentStreakStartDay = 0, freeze = 0;

            for (int day = 0; day <= weeks * DAYS; day++) {
                int week = day / DAYS;
                int dayOfWeek = day % DAYS;

                if (day == weeks * DAYS || streak[dayOfWeek][week] == 'X') {
                    if (maxStreak < currentStreak) {
                        maxStreak = currentStreak;
                        minStreakFreezeInMaxStreak = currentUseStreakFreezeCnt;
                        maxStreakStartDay = currentStreakStartDay;
                    } else if (maxStreak == currentStreak) {
                        if (minStreakFreezeInMaxStreak > currentUseStreakFreezeCnt) {
                            minStreakFreezeInMaxStreak = currentUseStreakFreezeCnt;
                            maxStreakStartDay = currentStreakStartDay;
                        }
                    }
                    freeze = 0;
                    currentStreak = 0;
                    currentUseStreakFreezeCnt = 0;
                    streakFail++;
                } else if (streak[dayOfWeek][week] == 'O') {
                    if (currentStreak == 0) {
                        currentStreakStartDay = week * DAYS + day;
                    }
                    currentUseStreakFreezeCnt += freeze;
                    freeze = 0;
                    currentStreak++;
                } else if (streak[dayOfWeek][week] == 'F') {
                    if (currentStreak != 0) {
                        freeze++;
                    }
                }
            }

            friends[idx] = new Friend(name, maxStreak, minStreakFreezeInMaxStreak, maxStreakStartDay, streakFail);
        }
        Arrays.sort(friends, (o1, o2) -> {
            if (o1.maxStreak != o2.maxStreak) return Integer.compare(o2.maxStreak, o1.maxStreak);
            else if (o1.minStreakFreezeInMaxStreak != o2.minStreakFreezeInMaxStreak)
                return Integer.compare(o1.minStreakFreezeInMaxStreak, o2.minStreakFreezeInMaxStreak);
            else if (o1.maxStreakStartDay != o2.maxStreakStartDay)
                return Integer.compare(o1.maxStreakStartDay, o2.maxStreakStartDay);
            else if (o1.streakFail != o2.streakFail) return Integer.compare(o1.streakFail, o2.streakFail);
            return o1.name.compareTo(o2.name);
        });

        int rank = 1;
        for (int idx = 0; idx < friendCnt; idx++) {
            if (idx > 0 && isDifferentRank(friends[idx - 1], friends[idx])) {
                rank++;
            }
            sb.append(String.format("%d. %s\n", rank, friends[idx].name));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isDifferentRank(Friend f1, Friend f2) {
        if (f1.maxStreak != f2.maxStreak) return true;
        if (f1.minStreakFreezeInMaxStreak != f2.minStreakFreezeInMaxStreak) return true;
        if (f1.maxStreakStartDay != f2.maxStreakStartDay) return true;
        if (f1.streakFail != f2.streakFail) return true;
        return false;
    }

    static class Friend {
        String name;
        int maxStreak;
        int minStreakFreezeInMaxStreak;
        int maxStreakStartDay;
        int streakFail;

        Friend(String name, int maxStreak, int minStreakFreezeInMaxStreak, int maxStreakStartDay, int streakFail) {
            this.name = name;
            this.maxStreak = maxStreak;
            this.minStreakFreezeInMaxStreak = minStreakFreezeInMaxStreak;
            this.maxStreakStartDay = maxStreakStartDay;
            this.streakFail = streakFail;
        }
    }
}
