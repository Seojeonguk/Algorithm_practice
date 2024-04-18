import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int workCnt = Integer.parseInt(br.readLine());
            Work[] works = new Work[workCnt];
            for (int workNum = 0; workNum < workCnt; workNum++) {
                StringTokenizer workInfo = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(workInfo.nextToken());
                int end = Integer.parseInt(workInfo.nextToken());

                works[workNum] = new Work(start, end);
            }

            Arrays.sort(works, Comparator.comparing(Work::getEnd).reversed());
            int latestStartTime = works[0].end;
            for (int i = 0; i < workCnt; i++) {
                latestStartTime = Math.min(latestStartTime, works[i].end) - works[i].start;
            }

            sb.append(latestStartTime < 0 ? -1 : latestStartTime);

            bw.write(sb.toString());
        }
    }

    static class Work {
        int start;
        int end;

        Work(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return this.end;
        }
    }
}
