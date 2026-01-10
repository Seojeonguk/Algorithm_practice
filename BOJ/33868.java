import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int solvedProblemCnt = Integer.parseInt(br.readLine());
        int solvedMaxTime = 0;
        int solvedShortestCode = Integer.MAX_VALUE;

        for (int i = 0; i < solvedProblemCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int solvedTime = Integer.parseInt(st.nextToken());
            int codeLength = Integer.parseInt(st.nextToken());

            solvedMaxTime = Math.max(solvedMaxTime, solvedTime);
            solvedShortestCode = Math.min(solvedShortestCode, codeLength);
        }

        sb.append((solvedMaxTime * solvedShortestCode) % 7 + 1);

        bw.write(sb.toString());
        bw.flush();
    }
}
