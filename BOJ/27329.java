import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();

        boolean isRepeat = true;
        for (int idx = 0; idx < strLength / 2; idx++) {
            if (str.charAt(idx) != str.charAt(idx + strLength / 2)) {
                isRepeat = false;
                break;
            }
        }
        sb.append(isRepeat ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
