import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int managedBlogDay = Integer.parseInt(st.nextToken());
        int during = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cumulativeVisitors = new int[managedBlogDay + 1];
        for (int day = 1; day <= managedBlogDay; day++) {
            int visitors = Integer.parseInt(st.nextToken());
            cumulativeVisitors[day] = cumulativeVisitors[day - 1] + visitors;
        }

        int cnt = 0;
        int maxVisitors = 0;
        for (int idx = during; idx <= managedBlogDay; idx++) {
            int visitors = cumulativeVisitors[idx] - cumulativeVisitors[idx - during];
            if (visitors > maxVisitors) {
                maxVisitors = visitors;
                cnt = 1;
            } else if (visitors == maxVisitors) {
                cnt++;
            }
        }
        if (maxVisitors == 0) {
            sb.append("SAD");
        } else {
            sb.append(maxVisitors).append("\n").append(cnt);
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
