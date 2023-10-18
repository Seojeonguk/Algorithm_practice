import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int diaryWidth = Integer.parseInt(st.nextToken());
        int diaryHeight = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int letterCnt = Integer.parseInt(st.nextToken());
        int letterWidth = Integer.parseInt(st.nextToken());
        int letterHeight = Integer.parseInt(st.nextToken());

        int letterInPage = (diaryWidth / letterWidth) * (diaryHeight / letterHeight);
        if (letterInPage == 0) {
            sb.append(-1);
        } else {
            sb.append(letterCnt / letterInPage + (letterCnt % letterInPage > 0 ? 1 : 0));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
