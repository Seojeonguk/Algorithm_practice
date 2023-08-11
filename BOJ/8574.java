import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int childrenCnt = Integer.parseInt(st.nextToken());
        int detectedDistance = Integer.parseInt(st.nextToken());
        int rescuerX = Integer.parseInt(st.nextToken());
        int rescuerY = Integer.parseInt(st.nextToken());

        int unsafeChildrenCnt = 0;
        for (int i = 0; i < childrenCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int childrenX = Integer.parseInt(st.nextToken());
            int childrenY = Integer.parseInt(st.nextToken());

            int diffX = Math.abs(rescuerX - childrenX);
            int diffY = Math.abs(rescuerY - childrenY);

            if (diffX * diffX + diffY * diffY > detectedDistance * detectedDistance) {
                unsafeChildrenCnt++;
            }
        }
        sb.append(unsafeChildrenCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
