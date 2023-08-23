import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String n = br.readLine();

        String nextPelindrome = calNextPelindrome(n);
        sb.append(nextPelindrome);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calNextPelindrome(String n) {
        String prev = n.substring(0, n.length() / 2 + (n.length() % 2 == 0 ? 0 : 1));
        if (n.length() == 1 && Long.parseLong(n) + 1 < 10) {
            return String.valueOf(Long.parseLong(prev) + 1);
        }
        String nextPelindrome = "";
        int nineCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '9') {
                nineCnt++;
            } else if (n.charAt(i) == '0') {
                zeroCnt++;
            }
        }
        if (nineCnt == n.length()) {
            nextPelindrome += "1";
            for (int i = 0; i < n.length() - 1; i++)
                nextPelindrome += "0";
            nextPelindrome += "1";
            return nextPelindrome;
        }
        if (zeroCnt == n.length() - 1) {
            nextPelindrome = n.substring(0, n.length() - 1) + "1";
            return nextPelindrome;
        }

        char[] cPrev = prev.toCharArray();
        for (int i = 0; i < cPrev.length; i++)
            nextPelindrome += cPrev[i];

        for (int i = cPrev.length - 1 - (n.length() % 2); i >= 0; i--) {
            nextPelindrome += cPrev[i];
        }

        if (n.compareTo(nextPelindrome) < 0) {
            return nextPelindrome;
        }

        nextPelindrome = "";
        cPrev[cPrev.length - 1]++;
        int carry = 0;
        for (int i = cPrev.length - 1; i >= 0; i--) {
            cPrev[i] += carry;
            carry = cPrev[i] / ('9' + 1);
            cPrev[i] = (char) ((cPrev[i] - '0') % 10 + '0');
        }

        for (int i = 0; i < cPrev.length; i++)
            nextPelindrome += cPrev[i];

        for (int i = cPrev.length - 1 - (n.length() % 2); i >= 0; i--) {
            nextPelindrome += cPrev[i];
        }

        return nextPelindrome;
    }
}
