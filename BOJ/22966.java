import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int problemCnt = Integer.parseInt(br.readLine());

        Problem[] problems = new Problem[problemCnt];
        for (int problem = 0; problem < problemCnt; problem++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            int difficulty = Integer.parseInt(st.nextToken());
            problems[problem] = new Problem(title, difficulty);
        }

        Arrays.sort(problems, Comparator.comparing(Problem::getDifficulty));

        sb.append(problems[0].title);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Problem {
        String title;
        int difficulty;

        Problem(String title, int difficulty) {
            this.title = title;
            this.difficulty = difficulty;
        }

        public int getDifficulty() {
            return difficulty;
        }
    }
}
