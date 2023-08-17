import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int notebookCnt = Integer.parseInt(br.readLine());

        int[] notebookNumbers = new int[notebookCnt];
        st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < notebookCnt; idx++) {
            notebookNumbers[idx] = Integer.parseInt(st.nextToken());
        }

        sb.append("1 1");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
