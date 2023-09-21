import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int courseCnt = Integer.parseInt(st.nextToken());
        int requiredCourseCnt = Integer.parseInt(st.nextToken());
        int openCourseCnt = Integer.parseInt(st.nextToken());

        Course[] courses = new Course[courseCnt];
        for (int i = 0; i < courseCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            courses[i] = new Course(name, score);
        }
        HashSet<String> openCourses = new HashSet<>();
        for (int i = 0; i < openCourseCnt; i++) {
            String openCourse = br.readLine();
            openCourses.add(openCourse);
        }
        Arrays.sort(courses, (o1, o2) -> {
            boolean isIn1 = openCourses.contains(o1.name);
            boolean isIn2 = openCourses.contains(o2.name);
            if (isIn1 && isIn2) {
                return Integer.compare(o1.score, o2.score);
            }
            if (isIn1) {
                return 1;
            }
            if (isIn2) {
                return -1;
            }
            return Integer.compare(o1.score, o2.score);
        });
        int minScore = 0, maxScore = 0;
        for (int i = courseCnt - openCourseCnt; i < courseCnt; i++) {
            minScore += courses[i].score;
            maxScore += courses[i].score;
        }

        for (int i = 0; i < requiredCourseCnt - openCourseCnt; i++) {
            minScore += courses[i].score;
            maxScore += courses[courseCnt - openCourseCnt - i - 1].score;
        }
        
        sb.append(String.format("%d %d", minScore, maxScore));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Course {
        String name;
        int score;

        Course(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
