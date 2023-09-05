import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int tableRowSize = Integer.parseInt(st.nextToken());
        int tableColSize = Integer.parseInt(st.nextToken());
        int intervalRow = Integer.parseInt(st.nextToken());
        int intervalCol = Integer.parseInt(st.nextToken());

        int row = (tableRowSize + intervalRow) / (intervalRow + 1);
        int col = (tableColSize + intervalCol) / (intervalCol + 1);
        sb.append(row * col);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
