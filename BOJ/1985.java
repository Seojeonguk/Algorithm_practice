import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int NOTHING = 0;
    static final int FRIEND = 1;
    static final int ALMOST_FRIEND = 2;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] x = st.nextToken().toCharArray();
            char[] y = st.nextToken().toCharArray();

            int result = calRelationship(x, y);
            if (result == FRIEND) {
                sb.append("friends\n");
            } else if (result == ALMOST_FRIEND) {
                sb.append("almost friends\n");
            } else {
                sb.append("nothing\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calRelationship(char[] x, char[] y) {
        int[] xAppeared = calAppeared(x);
        int[] yAppeared = calAppeared(y);

        if (isFriend(xAppeared, yAppeared)) {
            return FRIEND;
        }

        if (isAlmostFriends(xAppeared, y) || isAlmostFriends(yAppeared, x)) {
            return ALMOST_FRIEND;
        }

        return NOTHING;
    }

    public static boolean isAlmostFriends(int[] appeared, char[] c) {
        for (int idx = 1; idx < c.length; idx++) {
            if (c[idx - 1] < '9' && c[idx] > '0') {
                c[idx - 1]++;
                c[idx]--;

                if (isFriend(appeared, calAppeared(c))) {
                    return true;
                }

                c[idx - 1]--;
                c[idx]++;
            }

            if (idx == 1 && c[idx - 1] == '1') {
                continue;
            }

            if (c[idx - 1] > '0' && c[idx] < '9') {
                c[idx - 1]--;
                c[idx]++;

                if (isFriend(appeared, calAppeared(c))) {
                    return true;
                }

                c[idx - 1]++;
                c[idx]--;
            }
        }

        return false;
    }

    public static int[] calAppeared(char[] c) {
        int[] appeared = new int[10];
        for (int idx = 0; idx < c.length; idx++) {
            appeared[c[idx] - '0']++;
        }

        return appeared;
    }

    public static boolean isFriend(int[] a, int[] b) {
        for (int idx = 0; idx < 10; idx++) {
            if ((a[idx] > 0 && b[idx] == 0) || (a[idx] == 0 && b[idx] > 0)) {
                return false;
            }
        }

        return true;
    }
}
