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
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());


        int curHeight = 0;
        int upCnt = 0;

        while (true) {
            curHeight += up;
            upCnt++;
            if (curHeight >= height) {
                break;
            }
            curHeight -= down;
        }

        sb.append(upCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
