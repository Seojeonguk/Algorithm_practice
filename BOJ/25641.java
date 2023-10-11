import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());
        int sausage = 0, rice = 0;
        char[] sausages = br.readLine().toCharArray();
        for (int idx = 0; idx < length; idx++) {
            if (sausages[idx] == 's') sausage++;
            else rice++;
        }

        int curIdx = 0;
        while (curIdx < length && sausage != rice) {
            if (sausages[curIdx] == 's') sausage--;
            else rice--;
            curIdx++;
        }

        for (int idx = curIdx; idx < length; idx++) {
            sb.append(sausages[idx]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
