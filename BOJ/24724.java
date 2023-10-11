import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int managementCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < managementCnt; i++) {
            sb.append(String.format("Material Management %d\n", i + 1));
            sb.append("Classification ---- End!\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
