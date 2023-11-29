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
        while (true) {
            st = new StringTokenizer(br.readLine());
            int childCnt = Integer.parseInt(st.nextToken());
            int findChild = Integer.parseInt(st.nextToken());

            if (childCnt == 0 && findChild == 0) {
                break;
            }

            boolean[] isFind = new boolean[childCnt + 1];
            isFind[findChild] = true;
            for (int i = 0; i < childCnt - 2; i++) {
                int foundChild = Integer.parseInt(br.readLine());
                isFind[foundChild] = true;
            }

            for (int i = 1; i <= childCnt; i++) {
                if (!isFind[i]) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
