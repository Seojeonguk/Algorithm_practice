import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int participantCnt = Integer.parseInt(st.nextToken());
            int canSolvingProblemPeople = Integer.parseInt(st.nextToken());
            int hateProblemPeople = Integer.parseInt(st.nextToken());

            int minSolvingProblemPeople = canSolvingProblemPeople - Math.min(canSolvingProblemPeople, hateProblemPeople);
            int maxSolvingProblemPeople = Math.min(canSolvingProblemPeople, participantCnt - hateProblemPeople);

            sb.append(minSolvingProblemPeople).append(" ").append(maxSolvingProblemPeople).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
