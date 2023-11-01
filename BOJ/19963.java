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
        int firstPresentCnt = Integer.parseInt(st.nextToken());
        int secondPresentCnt = Integer.parseInt(st.nextToken());

        boolean[] readyForChildren = new boolean[childrenCnt + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < firstPresentCnt; idx++) {
            int children = Integer.parseInt(st.nextToken());
            readyForChildren[children] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < secondPresentCnt; idx++) {
            int children = Integer.parseInt(st.nextToken());
            readyForChildren[children] = true;
        }

        sb.append(childrenCnt - firstPresentCnt - secondPresentCnt).append("\n");
        for (int idx = 1; idx <= childrenCnt; idx++) {
            if (!readyForChildren[idx]) {
                sb.append(idx).append(" ");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
