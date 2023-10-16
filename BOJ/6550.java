import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str;
        while ((str = br.readLine()) != null && !str.equals("")) {
            String[] strSplit = str.split(" ");
            int aIdx = 0;
            for (int bIdx = 0; bIdx < strSplit[1].length() && aIdx < strSplit[0].length(); bIdx++) {
                if (strSplit[1].charAt(bIdx) == strSplit[0].charAt(aIdx)) {
                    aIdx++;
                }
            }
            sb.append(aIdx == strSplit[0].length() ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
