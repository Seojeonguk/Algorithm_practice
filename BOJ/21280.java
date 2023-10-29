import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lectureCnt = Integer.parseInt(br.readLine());
        int[] providedLectures = new int[lectureCnt];

        st = new StringTokenizer(br.readLine());
        int emptyLecture = 0, missedLecture = 0;
        for (int idx = 0; idx < lectureCnt; idx++) {
            providedLectures[idx] = Integer.parseInt(st.nextToken());
            if (idx > 0) {
                if (providedLectures[idx - 1] < providedLectures[idx]) {
                    missedLecture += providedLectures[idx] - providedLectures[idx - 1];
                } else {
                    emptyLecture += providedLectures[idx - 1] - providedLectures[idx];
                }
            }
        }

        sb.append(emptyLecture).append(" ").append(missedLecture);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
