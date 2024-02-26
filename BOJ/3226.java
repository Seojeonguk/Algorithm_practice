import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int WEEK = 7 * 60;
    static final int WEEK_COST = 10;
    static final int NIGHT = 19 * 60;
    static final int NIGHT_COST = 5;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int callCnt = Integer.parseInt(br.readLine());
        int totalCallCost = 0;
        for (int callNum = 0; callNum < callCnt; callNum++) {
            StringTokenizer callInfo = new StringTokenizer(br.readLine());
            String startCallTime = callInfo.nextToken();
            int callingTime = Integer.parseInt(callInfo.nextToken());

            int cost = calCallCost(startCallTime, callingTime);
            totalCallCost += cost;
        }

        sb.append(totalCallCost);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calCallCost(String startCallTime, int callingTime) {
        String[] times = startCallTime.split(":");
        int startCallHour = Integer.parseInt(times[0]);
        int startCallMinute = Integer.parseInt(times[1]);

        int totalStartCallMinute = startCallHour * 60 + startCallMinute;
        int totalEndCallMinute = (totalStartCallMinute + callingTime) % (24 * 60);

        int cost;
        if (NIGHT <= totalStartCallMinute || totalEndCallMinute <= WEEK) {
            cost = callingTime * NIGHT_COST;
        } else if (WEEK <= totalStartCallMinute && totalEndCallMinute <= NIGHT) {
            cost = callingTime * WEEK_COST;
        } else if (WEEK > totalStartCallMinute) {
            cost = (WEEK - totalStartCallMinute) * NIGHT_COST + (totalEndCallMinute - WEEK) * WEEK_COST;
        } else {
            cost = (NIGHT - totalStartCallMinute) * WEEK_COST + (totalEndCallMinute - NIGHT) * NIGHT_COST;
        }

        return cost;
    }
}
