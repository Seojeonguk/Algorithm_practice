import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int problemCnt = Integer.parseInt(br.readLine());

        char[] answers;
        answers = new char[problemCnt];

        for (int i = 0; i < problemCnt; i++) {
            answers[i] = br.readLine().charAt(0);
        }

        int correctCnt = 0;
        for (int i = 0; i < problemCnt; i++) {
            char response = br.readLine().charAt(0);
            if (answers[i] == response) {
                correctCnt++;
            }
        }
        sb.append(correctCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
