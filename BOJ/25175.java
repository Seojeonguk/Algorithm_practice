import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken());
        int curPeopleNum = Integer.parseInt(st.nextToken());
        int tofu = Integer.parseInt(st.nextToken());

        curPeopleNum += tofu - 4;
        while (curPeopleNum < 0) {
            curPeopleNum += peopleCnt;
        }
        curPeopleNum %= peopleCnt;
        sb.append(curPeopleNum + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
