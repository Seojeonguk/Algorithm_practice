import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int homeworkCnt = Integer.parseInt(br.readLine());
        Homework[] homeworks = new Homework[homeworkCnt];

        for (int homeworkNum = 0; homeworkNum < homeworkCnt; homeworkNum++) {
            StringTokenizer homeworkInfo = new StringTokenizer(br.readLine());
            int takeTime = Integer.parseInt(homeworkInfo.nextToken());
            int deadline = Integer.parseInt(homeworkInfo.nextToken());

            homeworks[homeworkNum] = new Homework(takeTime, deadline);
        }

        Arrays.sort(homeworks, Comparator.comparingInt(Homework::getDeadline).reversed());
        
        int fastestStartDay = Integer.MAX_VALUE;
        for (int i = 0; i < homeworkCnt; i++) {
            fastestStartDay = Math.min(fastestStartDay, homeworks[i].deadline) - homeworks[i].takeTime;
        }

        sb.append(fastestStartDay);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Homework {
        int takeTime;
        int deadline;

        Homework(int takeTime, int deadline) {
            this.takeTime = takeTime;
            this.deadline = deadline;
        }

        public int getDeadline() {
            return this.deadline;
        }
    }
}
