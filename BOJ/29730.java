import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String BOJ_LINK = "boj.kr/";

    public static void main(String[] args) throws Exception {
        int studyCnt = Integer.parseInt(br.readLine());
        String[] studies = new String[studyCnt];

        for (int idx = 0; idx < studyCnt; idx++) {
            studies[idx] = br.readLine();
        }

        Arrays.sort(studies, (o1, o2) -> {
            if (o1.startsWith(BOJ_LINK) && o2.startsWith(BOJ_LINK)) {
                int problemNum1 = Integer.parseInt(o1.substring(BOJ_LINK.length()));
                int problemNum2 = Integer.parseInt(o2.substring(BOJ_LINK.length()));
                return Integer.compare(problemNum1, problemNum2);
            }
            if (o1.startsWith(BOJ_LINK)) {
                return 1;
            } else if (o2.startsWith(BOJ_LINK)) {
                return -1;
            }
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length());
        });
        for (String study : studies) {
            sb.append(study).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
