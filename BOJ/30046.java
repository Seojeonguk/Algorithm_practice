import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int strLength = Integer.parseInt(br.readLine());
        String[] str = new String[3];
        for (int idx = 0; idx < 3; idx++) {
            str[idx] = br.readLine();
        }

        sb.append(solve(strLength, str) ? "HJS! HJS! HJS!" : "Hmm...");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean solve(int strLength, String[] str) {
        int startIdx = -1;
        for (int idx = 0; idx < strLength; idx++) {
            if (str[0].charAt(idx) != str[1].charAt(idx) || str[1].charAt(idx) != str[2].charAt(idx)) {
                startIdx = idx;
                break;
            }
        }
        if (startIdx == -1) {
            return false;
        }
        char a = str[0].charAt(startIdx);
        char b = str[1].charAt(startIdx);
        char c = str[2].charAt(startIdx);

        boolean ret = (a != b && b != c && a != c);
        if (a == b) {
            int secondIdx = getDiffIdx(str[0], str[1], strLength, startIdx);
            if (secondIdx == -1) {
                return false;
            }
            char d = str[0].charAt(secondIdx);
            char e = str[1].charAt(secondIdx);
            if (d != c || e != a) {
                ret = true;
            }
        } else if (b == c) {
            int secondIdx = getDiffIdx(str[1], str[2], strLength, startIdx);
            if (secondIdx == -1) {
                return false;
            }
            char d = str[1].charAt(secondIdx);
            char e = str[2].charAt(secondIdx);
            if (d != b || e != a) {
                ret = true;
            }
        }

        return ret;
    }

    public static int getDiffIdx(String a, String b, int strLength, int startIdx) {
        int diffIdx = -1;

        for (int idx = startIdx; idx < strLength; idx++) {
            if (a.charAt(idx) != b.charAt(idx)) {
                diffIdx = idx;
                break;
            }
        }

        return diffIdx;
    }
}
