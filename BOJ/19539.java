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
        int appleTreeNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int sumWantAppleTreeHeight = 0;
        int two = 0;
        for (int i = 0; i < appleTreeNum; i++) {
            int height = Integer.parseInt(st.nextToken());
            sumWantAppleTreeHeight += height;
            two += height / 2;
        }

        sb.append(sumWantAppleTreeHeight % 3 == 0 && two >= sumWantAppleTreeHeight / 3 ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
