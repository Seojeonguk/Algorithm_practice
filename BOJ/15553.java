import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int friendCnt = Integer.parseInt(st.nextToken());
            int matchCnt = Integer.parseInt(st.nextToken());

            int[] friendArrivalTimes = new int[friendCnt];
            for (int i = 0; i < friendCnt; i++) {
                friendArrivalTimes[i] = Integer.parseInt(br.readLine());
            }

            sb.append(calMinTurnOnStoveTime(friendArrivalTimes, matchCnt));

            bw.write(sb.toString());
        }
    }

    public static int calMinTurnOnStoveTime(int[] friendArrivalTimes, int matchCnt) {
        int turnOnStoveTime = friendArrivalTimes.length;

        ArrayList<Integer> diff = new ArrayList<>();
        for (int i = 0; i < friendArrivalTimes.length - 1; i++) {
            diff.add(friendArrivalTimes[i + 1] - friendArrivalTimes[i]);
        }

        Collections.sort(diff);

        int turnOnStoveCnt = friendArrivalTimes.length - matchCnt;
        for (int i = 0; i < turnOnStoveCnt; i++) {
            turnOnStoveTime += diff.get(i) - 1;
        }

        return turnOnStoveTime;
    }
}
