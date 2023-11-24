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
        String str = br.readLine();

        Stack<Integer> s = new Stack<>();

        int totalLength = 0;
        int length = 0;
        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);

            if (c == '(') {
                s.push(length - 1);
                s.push(str.charAt(idx - 1) - '0');
                length = 0;
            } else if (c == ')') {
                int multiple = length * s.pop() + s.pop();
                length = multiple;
            } else {
                length++;
            }
        }

        totalLength += length;

        sb.append(totalLength);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
