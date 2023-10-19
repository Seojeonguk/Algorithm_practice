import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int sanggeunCD = Integer.parseInt(st.nextToken());
            int sunyoungCD = Integer.parseInt(st.nextToken());

            if (sanggeunCD == 0 && sunyoungCD == 0) {
                break;
            }

            HashSet<Integer> cds = new HashSet<>();
            int cd = 0;
            while (sanggeunCD-- > 0) {
                int cdNum = Integer.parseInt(br.readLine());
                cds.add(cdNum);
            }

            while (sunyoungCD-- > 0) {
                int cdNum = Integer.parseInt(br.readLine());
                if (cds.contains(cdNum)) {
                    cd++;
                }
            }
            sb.append(cd).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
