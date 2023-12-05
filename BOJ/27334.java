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
        int studentNum = Integer.parseInt(br.readLine());
        int[] ranks = new int[studentNum];
        int[] scores = new int[studentNum];

        TreeSet<Integer> ts = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            ts.add(score);
        }

        int rank = 1, rankStudent = 0;
        for (int score : ts) {
            for (int i = 0; i < studentNum; i++) {
                if (scores[i] == score) {
                    ranks[i] = rank;
                    rankStudent++;
                }
            }
            rank += rankStudent;
            rankStudent = 0;
        }

        for (int i = 0; i < studentNum; i++) {
            sb.append(ranks[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
