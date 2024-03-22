import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int scheduleCnt = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[scheduleCnt + 1];
        for (int scheduleNum = 0; scheduleNum < scheduleCnt; scheduleNum++) {
            StringTokenizer scheduleInfo = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(scheduleInfo.nextToken());
            int end = Integer.parseInt(scheduleInfo.nextToken());

            schedules[scheduleNum] = new Schedule(start, end);
        }
        schedules[scheduleCnt] = new Schedule(367, 367);

        Arrays.sort(schedules, (o1, o2) -> {
            if (o1.start == o2.start) {
                return Integer.compare(o2.end - o2.start, o1.end - o1.start);
            }
            return Integer.compare(o1.start, o2.start);
        });

        int requiredCoatedPaperArea = 0;
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int coatedPaperStart = 0, coatedPaperEnd = -1, coatedPaperHeight = 0;
        for (int scheduleNum = 0; scheduleNum < scheduleCnt + 1; scheduleNum++) {
            int start = schedules[scheduleNum].start;
            int end = schedules[scheduleNum].end;

            if (start > coatedPaperEnd + 1) {
                int coatedPaperArea = (coatedPaperEnd - coatedPaperStart + 1) * coatedPaperHeight;
                requiredCoatedPaperArea += coatedPaperArea;

                ends.clear();
                coatedPaperStart = start;
                coatedPaperHeight = 0;
            }

            while (!ends.isEmpty()) {
                if (ends.peek() < start) {
                    ends.poll();
                } else {
                    break;
                }
            }
            ends.add(end);
            coatedPaperEnd = Math.max(coatedPaperEnd, end);
            coatedPaperHeight = Math.max(coatedPaperHeight, ends.size());
        }

        sb.append(requiredCoatedPaperArea);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Schedule {
        int start, end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
