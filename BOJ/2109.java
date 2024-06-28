import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int requestLectureCnt = Integer.parseInt(br.readLine());
            PriorityQueue<Lecture> lectures = new PriorityQueue<>((o1, o2) -> {
                if (o1.fee == o2.fee) {
                    return Integer.compare(o2.deadline, o1.deadline);
                }
                return Integer.compare(o2.fee, o1.fee);

            });

            int maxDeadline = 0;
            for (int i = 0; i < requestLectureCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int fee = Integer.parseInt(st.nextToken());
                int deadline = Integer.parseInt(st.nextToken());
                maxDeadline = Math.max(maxDeadline, deadline);

                lectures.add(new Lecture(deadline, fee));
            }

            int maxEarned = 0;
            boolean[] isLecture = new boolean[maxDeadline + 1];
            while (!lectures.isEmpty()) {
                Lecture lecture = lectures.poll();
                for (int i = lecture.deadline; i > 0; i--) {
                    if (!isLecture[i]) {
                        isLecture[i] = true;
                        maxEarned += lecture.fee;
                        break;
                    }
                }
            }

            sb.append(maxEarned);

            bw.write(sb.toString());
        }
    }

    static class Lecture {
        int deadline;
        int fee;

        public Lecture(int deadline, int fee) {
            this.deadline = deadline;
            this.fee = fee;
        }
    }
}
