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
        int lectureNum = Integer.parseInt(br.readLine());
        String lectureInfo = br.readLine();
        boolean[] canStay = new boolean[lectureNum];

        for (int i = 0; i < lectureNum; i++) {
            if (lectureInfo.charAt(i) == '1') {
                for (int j = i; j < Math.min(i + 3, lectureNum); j++) {
                    canStay[j] = true;
                }
            }
        }

        int canStayCnt = 0;
        for (int i = 0; i < lectureNum; i++) {
            if (canStay[i]) {
                canStayCnt++;
            }
        }

        sb.append(canStayCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
