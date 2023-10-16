import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int knowingSetMenuCnt = Integer.parseInt(br.readLine());
        String[] setMenuInfo = br.readLine().split(" ");
        
        sb.append(setMenuInfo[0]).append("\n");
        for (int idx = 1; idx < setMenuInfo.length; idx++) {
            sb.append(setMenuInfo[idx]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
