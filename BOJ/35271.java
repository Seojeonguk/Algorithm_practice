import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int classCnt = Integer.parseInt(st.nextToken());

        int[] classSizes = new int[classCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int classNum = 1; classNum <= classCnt; classNum++) {
            classSizes[classNum] = Integer.parseInt(st.nextToken());
        }

        int[] studentClasses = new int[studentCnt + 1];
        Arrays.fill(studentClasses, -1);

        for (int studentNum = 1; studentNum <= studentCnt; studentNum++) {
            st = new StringTokenizer(br.readLine());
            int firstClass = Integer.parseInt(st.nextToken());
            int secondClass = Integer.parseInt(st.nextToken());
            int thirdClass = Integer.parseInt(st.nextToken());

            if (classSizes[firstClass] > 0) {
                classSizes[firstClass] -= 1;
                studentClasses[studentNum] = firstClass;
            } else if (classSizes[secondClass] > 0) {
                classSizes[secondClass] -= 1;
                studentClasses[studentNum] = secondClass;
            } else if (classSizes[thirdClass] > 0) {
                classSizes[thirdClass] -= 1;
                studentClasses[studentNum] = thirdClass;
            }
        }

        for (int studentNum = 1; studentNum <= studentCnt; studentNum++) {
            sb.append(studentClasses[studentNum]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
