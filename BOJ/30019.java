import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int lectureCnt = Integer.parseInt(st.nextToken());
        int reservationCnt = Integer.parseInt(st.nextToken());

        int[] lectures = new int[lectureCnt + 1];

        while (reservationCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int lectureNum = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            if (lectures[lectureNum] <= startTime) {
                lectures[lectureNum] = endTime;
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
