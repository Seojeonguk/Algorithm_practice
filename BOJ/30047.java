import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        char[] str = br.readLine().toCharArray();
        Stack<Integer> s = new Stack<>();
        boolean isGood = true;
        for (int idx = str.length - 1; idx >= 0; idx--) {
            if (str[idx] == 'x') {
                s.push(0);
            } else if (str[idx] == 'g') {
                if (s.isEmpty()) {
                    isGood = false;
                    break;
                }
                int top = s.pop();
                s.push(top + 1);
            } else if (str[idx] == 'f') {
                if (s.size() < 2) {
                    isGood = false;
                    break;
                }
                int firstTop = s.pop();
                int secondTop = s.pop();
                s.push(Math.min(firstTop, secondTop));
            }
        }

        if (s.size() != 1 || !isGood) {
            sb.append(-1);
        } else {
            sb.append(s.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
