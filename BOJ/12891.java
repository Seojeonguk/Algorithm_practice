import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int DNALength = Integer.parseInt(st.nextToken());
        int passwordLength = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] minUses = new int[4];
        for (int i = 0; i < 4; i++) {
            minUses[i] = Integer.parseInt(st.nextToken());
        }

        int canMakePassword = 0;
        int[] currentUses = new int[4];
        for (int i = 0; i < DNALength; i++) {
            int addIdx = getIdx(DNA.charAt(i));
            currentUses[addIdx]++;

            if (i >= passwordLength) {
                int pullIdx = getIdx(DNA.charAt(i - passwordLength));
                currentUses[pullIdx]--;
            }

            if (i >= passwordLength - 1) {
                boolean canPassword = true;
                for (int j = 0; j < 4; j++) {
                    if (minUses[j] > currentUses[j]) {
                        canPassword = false;
                        break;
                    }
                }
                if (canPassword) {
                    canMakePassword++;
                }
            }
        }

        sb.append(canMakePassword);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getIdx(char c) {
        int idx = -1;

        if (c == 'A') idx = 0;
        else if (c == 'C') idx = 1;
        else if (c == 'G') idx = 2;
        else if (c == 'T') idx = 3;

        return idx;
    }
}
