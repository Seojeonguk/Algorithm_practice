import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int maxArraySize = Integer.parseInt(st.nextToken());
        int saveCnt = Integer.parseInt(st.nextToken());
        int removeCnt = Integer.parseInt(st.nextToken());

        int currentArraySize = 0;
        for (int i = 0; i < saveCnt + removeCnt; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                currentArraySize--;
            } else {
                if (currentArraySize == maxArraySize) {
                    maxArraySize *= 2;
                }
                currentArraySize++;
            }
        }
        sb.append(maxArraySize);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
