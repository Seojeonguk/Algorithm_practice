import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int patty = Integer.parseInt(st.nextToken());
        int cheese = Integer.parseInt(st.nextToken());

        int requiredCheese = Math.min(patty - 1, cheese);
        sb.append(requiredCheese * 2 + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
