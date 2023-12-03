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

    static final String UOSPC = "uospc";

    public static void main(String[] args) throws Exception {
        int strLength = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int[] appeared = new int[26];

        for (int i = 0; i < strLength; i++) {
            appeared[str[i] - 'a']++;
        }

        int canMakeMaxUOSPC = Integer.MAX_VALUE;
        for (int idx = 0; idx < UOSPC.length(); idx++) {
            char c = UOSPC.charAt(idx);
            canMakeMaxUOSPC = Math.min(canMakeMaxUOSPC, appeared[c - 'a']);
        }

        sb.append(canMakeMaxUOSPC);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
