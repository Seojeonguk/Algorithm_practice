import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        boolean isAnagram = checkAnagram(a, b);
        sb.append(isAnagram ? "Is an anagram." : "Is not an anagram.");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkAnagram(char[] a, char[] b) {
        int[] aAppeared = calAppeared(a);
        int[] bAppeared = calAppeared(b);

        for (int idx = 0; idx < 26; idx++) {
            if (aAppeared[idx] != bAppeared[idx]) {
                return false;
            }
        }

        return true;
    }

    public static int[] calAppeared(char[] a) {
        int[] appeared = new int[26];
        for (int idx = 0; idx < a.length; idx++) {
            if (a[idx] == ' ') {
                continue;
            }
            appeared[a[idx] - 'A']++;
        }

        return appeared;
    }
}
