import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int ALPHABET_SIZE = 26;
    final static String GOLD_CHIP = "BRONZESILVER";

    public static void main(String[] args) throws Exception {
        int sealCnt = Integer.parseInt(br.readLine());
        String seals = br.readLine();
        int[] sealAppearances = getAlphabetAppearances(seals);
        int[] goldChipAppearances = getAlphabetAppearances(GOLD_CHIP);

        int maxGoldChip = sealCnt;
        for (int idx = 0; idx < ALPHABET_SIZE; idx++) {
            if (goldChipAppearances[idx] > 0) {
                maxGoldChip = Math.min(maxGoldChip, sealAppearances[idx] / goldChipAppearances[idx]);
            }
        }
        sb.append(maxGoldChip);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] getAlphabetAppearances(String str) {
        int[] appearance = new int[ALPHABET_SIZE];
        for (int idx = 0; idx < str.length(); idx++) {
            appearance[str.charAt(idx) - 'A']++;
        }
        return appearance;
    }
}
