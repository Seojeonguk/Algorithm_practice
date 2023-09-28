import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int buttonClickCnt = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        while (buttonClickCnt-- > 0) {
            sum += Integer.parseInt(st.nextToken());
        }
        if (sum > 0) {
            sb.append("Right");
        } else if (sum < 0) {
            sb.append("Left");
        } else {
            sb.append("Stay");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
