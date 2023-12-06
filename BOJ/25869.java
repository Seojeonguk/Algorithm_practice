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
        st = new StringTokenizer(br.readLine());

        int wallWidth = Integer.parseInt(st.nextToken());
        int wallHeight = Integer.parseInt(st.nextToken());
        int minimumWindowGap = Integer.parseInt(st.nextToken());

        int maxHeight = Math.max(0, wallHeight - minimumWindowGap * 2);
        int maxWidth = Math.max(0, wallWidth - minimumWindowGap * 2);

        sb.append(maxHeight * maxWidth);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
