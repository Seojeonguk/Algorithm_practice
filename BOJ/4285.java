import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int takingCourseCnt = Integer.parseInt(st.nextToken());
            if (takingCourseCnt == 0) {
                break;
            }

            int categoryCnt = Integer.parseInt(st.nextToken());
            HashSet<String> chosenCourses = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < takingCourseCnt; i++) {
                String chosenCourse = st.nextToken();
                chosenCourses.add(chosenCourse);
            }

            boolean canGraduate = true;
            for (int i = 0; i < categoryCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int courseCnt = Integer.parseInt(st.nextToken());
                int minimumTakenCourse = Integer.parseInt(st.nextToken());

                int takenCourseCnt = 0;
                for (int j = 0; j < courseCnt; j++) {
                    String course = st.nextToken();
                    if (chosenCourses.contains(course)) {
                        takenCourseCnt++;
                    }
                }

                canGraduate &= (takenCourseCnt >= minimumTakenCourse);
            }

            sb.append(canGraduate ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
