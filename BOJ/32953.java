import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int classCnt;
        private int qualifiedStudentCnt;
        private Map<String, Integer> studentIdToParticipationCnt;
        private Set<String> qualifiedStudentIds;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classCnt = Integer.parseInt(st.nextToken());
            qualifiedStudentCnt = Integer.parseInt(st.nextToken());

            studentIdToParticipationCnt = new HashMap<>();
            qualifiedStudentIds = new HashSet<>();
        }

        public void solve() throws IOException {
            for (int classNum = 0; classNum < classCnt; classNum++) {
                int studentCnt = Integer.parseInt(br.readLine());

                StringTokenizer students = new StringTokenizer(br.readLine());
                for (int studentNum = 0; studentNum < studentCnt; studentNum++) {
                    String studentId = students.nextToken();

                    int participantCnt = studentIdToParticipationCnt.getOrDefault(studentId, 1) + 1;
                    studentIdToParticipationCnt.put(studentId, participantCnt);

                    if (qualifiedStudentCnt < participantCnt) {
                        qualifiedStudentIds.add(studentId);
                    }
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(qualifiedStudentIds.size()));
            bw.flush();
        }
    }
}
