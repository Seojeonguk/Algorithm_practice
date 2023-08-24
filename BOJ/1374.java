import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lectureCnt = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < lectureCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Lecture lecture = new Lecture(no, start, end);
            lectures.add(lecture);
        }
        Collections.sort(lectures, (o1, o2) -> {
            return Integer.compare(o1.start, o2.start);
        });

        int requiredLectureCnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < lectureCnt; i++) {
            while (!pq.isEmpty()) {
                if (pq.peek() > lectures.get(i).start) {
                    break;
                }
                pq.poll();
            }
            pq.add(lectures.get(i).end);
            requiredLectureCnt = Math.max(requiredLectureCnt, pq.size());
        }
        sb.append(requiredLectureCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Lecture {
        int no;
        int start;
        int end;

        Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }
    }
}
