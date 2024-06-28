import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nameCnt = Integer.parseInt(br.readLine());
            char[][] names = new char[nameCnt][];
            for (int i = 0; i < nameCnt; i++) {
                names[i] = br.readLine().toCharArray();
            }

            sb.append(getMaxDiffChar(nameCnt, names));

            bw.write(sb.toString());
        }
    }

    public static int getMaxDiffChar(int nameCnt, char[][] names) {
        int maxDiffChar = 0;
        boolean[] appeared = new boolean[26];

        for (int i = 0; i < nameCnt; i++) {
            Arrays.fill(appeared, false);

            int diffChar = 0;
            for (char c : names[i]) {
                if (!appeared[c - 'a']) {
                    appeared[c - 'a'] = true;
                    diffChar++;
                }
            }

            maxDiffChar = Math.max(maxDiffChar, diffChar);
        }

        return maxDiffChar;
    }
}
