import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int hiredCow = Integer.parseInt(br.readLine());

            Cow[] cows = new Cow[hiredCow];

            for (int cowNum = 0; cowNum < hiredCow; cowNum++) {
                StringTokenizer lifeguard = new StringTokenizer(br.readLine());
                int startTime = Integer.parseInt(lifeguard.nextToken());
                int endTime = Integer.parseInt(lifeguard.nextToken());

                cows[cowNum] = new Cow(startTime, endTime);
            }

            Arrays.sort(cows);

            int maxCovredTime = 0;
            for (int fireCow = 0; fireCow < hiredCow; fireCow++) {
                maxCovredTime = Math.max(maxCovredTime, getMaxCoveredTime(cows, fireCow));
            }

            sb.append(maxCovredTime);

            bw.write(sb.toString());
        }
    }

    public static int getMaxCoveredTime(Cow[] cows, int fireCow) {
        int coveredTime = 0;

        int start = -1, end = -1;
        for (int cowNum = 0; cowNum < cows.length; cowNum++) {
            if (cowNum == fireCow) {
                continue;
            }

            if (end < cows[cowNum].start) {
                coveredTime += end - start;
                start = cows[cowNum].start;
                end = cows[cowNum].end;
            } else {
                end = Math.max(end, cows[cowNum].end);
            }
        }

        coveredTime += end - start;

        return coveredTime;
    }

    static class Cow implements Comparable<Cow> {
        int start, end;

        public Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(start, o.start);
        }
    }
}
