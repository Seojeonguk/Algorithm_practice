import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static String ESCAPE_FAIL = "ESCAPE FAILED";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer schoolInfo = new StringTokenizer(br.readLine());
        int teacherCnt = Integer.parseInt(schoolInfo.nextToken());
        int classCnt = Integer.parseInt(schoolInfo.nextToken());

        char[][] teacherPatrols = new char[teacherCnt][classCnt];
        for (int teacherNum = 0; teacherNum < teacherCnt; teacherNum++) {
            teacherPatrols[teacherNum] = br.readLine().toCharArray();
        }

        int fastestEscapedClass = calFastestEscapedClass(teacherPatrols, teacherCnt, classCnt);
        sb.append(fastestEscapedClass == -1 ? ESCAPE_FAIL : fastestEscapedClass);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calFastestEscapedClass(char[][] patrols, int teacherCnt, int classCnt) {
        for (int classNum = 0; classNum < classCnt; classNum++) {
            boolean isPatrolAnyTeacher = false;
            for (int teacherNum = 0; teacherNum < teacherCnt; teacherNum++) {
                if (patrols[teacherNum][classNum] == 'O') {
                    isPatrolAnyTeacher = true;
                    break;
                }
            }
            if (!isPatrolAnyTeacher) {
                return classNum + 1;
            }
        }

        return -1;
    }
}
