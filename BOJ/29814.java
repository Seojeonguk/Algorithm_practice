import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int homeworkCnt = Integer.parseInt(st.nextToken());
        int cutLine = Integer.parseInt(st.nextToken());

        Homework[] homeworks = new Homework[homeworkCnt];
        for (int idx = 0; idx < homeworkCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int resolutionTime = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            homeworks[idx] = new Homework(deadline, resolutionTime, point);
        }

        Arrays.sort(homeworks, Comparator.comparingInt(o -> o.deadline - o.time));

        PriorityQueue<Integer> points = new PriorityQueue<>();
        int totalPoint = 0;
        for (int idx = 0; idx < homeworkCnt; idx++) {
            points.add(homeworks[idx].point);
            totalPoint += homeworks[idx].point;
            if (points.size() > homeworks[idx].deadline - homeworks[idx].time + 1) {
                int point = points.poll();
                totalPoint -= point;
            }
        }
        
        while (!points.isEmpty()) {
            if (totalPoint - points.peek() < cutLine) {
                break;
            }
            int point = points.poll();
            totalPoint -= point;
        }

        if (totalPoint >= cutLine) {
            sb.append(points.size());
        } else {
            sb.append("I'm sorry professor Won!");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Homework {
        int deadline;
        int time;
        int point;

        Homework(int deadline, int time, int point) {
            this.deadline = deadline;
            this.time = time;
            this.point = point;
        }
    }
}
