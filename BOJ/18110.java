import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int opinionCnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> opinions = new ArrayList<>();
        int totalOpinion = 0;
        for (int i = 0; i < opinionCnt; i++) {
            int opinion = Integer.parseInt(br.readLine());
            totalOpinion += opinion;
            opinions.add(opinion);
        }
        Collections.sort(opinions);

        int exceptionOpinionCnt = Math.round(1.0f * opinionCnt * 15 / 100);
        for (int i = 0; i < exceptionOpinionCnt; i++) {
            totalOpinion -= opinions.get(i);
            totalOpinion -= opinions.get(opinionCnt - i - 1);
        }

        int average = Math.round(1.0f * totalOpinion / (opinionCnt - 2 * exceptionOpinionCnt));
        sb.append(average);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
