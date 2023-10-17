import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String firstPassword = br.readLine();
        String secondPassword = br.readLine();

        int loginSequenceCnt = 1;
        for (int idx = 0; idx < firstPassword.length(); idx++) {
            if (firstPassword.charAt(idx) != secondPassword.charAt(idx)) {
                loginSequenceCnt *= 2;
            }
        }
        sb.append(loginSequenceCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
