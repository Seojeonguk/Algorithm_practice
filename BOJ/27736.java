import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String APPROVED = "APPROVED";
    final static String REJECTED = "REJECTED";
    final static String INVALID = "INVALID";

    public static void main(String[] args) throws Exception {
        int studentNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int agreement = 0, opposition = 0, drop = 0;
        for (int student = 0; student < studentNum; student++) {
            int vote = Integer.parseInt(st.nextToken());
            if (vote == 1) agreement++;
            else if (vote == -1) opposition++;
            else drop++;
        }
        if (drop >= (studentNum + 1) / 2) {
            sb.append(INVALID);
        } else if (agreement <= opposition) {
            sb.append(REJECTED);
        } else {
            sb.append(APPROVED);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
