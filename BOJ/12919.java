import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String current = br.readLine();
        String target = br.readLine();

        boolean canReachedTarget = game(current, target);
        sb.append(canReachedTarget ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean game(String current, String target) {
        if (current.length() == target.length()) {
            return current.equals(target);
        }
        boolean canReachedTarget = false;
        if (target.charAt(target.length() - 1) == 'A') {
            canReachedTarget |= game(current, target.substring(0, target.length() - 1));
        }
        if (target.charAt(0) == 'B') {
            canReachedTarget |= game(current, new StringBuffer(target.substring(1)).reverse().toString());
        }

        return canReachedTarget;
    }
}
