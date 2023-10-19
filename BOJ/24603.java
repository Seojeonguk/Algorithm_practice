import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int recipeCnt = Integer.parseInt(st.nextToken());
        int producePortion = Integer.parseInt(st.nextToken());
        int needPortion = Integer.parseInt(st.nextToken());

        while (recipeCnt-- > 0) {
            int neededIngredient = Integer.parseInt(br.readLine());

            sb.append(needPortion * neededIngredient / producePortion).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
