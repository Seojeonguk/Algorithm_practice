import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        for (int i = 0; i < a - 1; i++)
            sb.append(str.charAt(i));

        for (int i = b - 1; i >= a - 1; i--)
            sb.append(str.charAt(i));

        for (int i = b; i < str.length(); i++)
            sb.append(str.charAt(i));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
