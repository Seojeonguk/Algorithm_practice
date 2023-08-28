import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int wordCnt = Integer.parseInt(st.nextToken());
        int contestQuestionCnt = Integer.parseInt(st.nextToken());

        int canSpelledCnt = 0;

        Loop1:
        for (int i = 0; i < wordCnt; i++) {
            String word = br.readLine();
            boolean[] isExist = new boolean[contestQuestionCnt + 1];
            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'A' + 1;
                if (idx > contestQuestionCnt || isExist[idx]) {
                    continue Loop1;
                }
                isExist[idx] = true;
            }
            canSpelledCnt++;
        }
        sb.append(canSpelledCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
