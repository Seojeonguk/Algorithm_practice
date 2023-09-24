import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String USE_ZERO_ENERGY = "Nalmeok";
    final static String MAKE_ZERO_HYU = "I love HanYang University";

    public static void main(String[] args) throws Exception {
        int wordLength = Integer.parseInt(br.readLine());
        String word = br.readLine();
        st = new StringTokenizer(br.readLine());
        int deleteEnergy = Integer.parseInt(st.nextToken());
        int dragDeleteEnergy = Integer.parseInt(st.nextToken());

        int useEnergy = 0, continuesCnt = 0;
        int hCnt = 0, uCnt = 0, yCnt = 0;
        for (int idx = 0; idx < wordLength; idx++) {
            char c = word.charAt(idx);
            if (c != 'H' && c != 'U' && c != 'Y') {
                continuesCnt++;
                continue;
            }
            if (c == 'H') hCnt++;
            else if (c == 'U') uCnt++;
            else if (c == 'Y') yCnt++;
            useEnergy += Math.min(continuesCnt * deleteEnergy, dragDeleteEnergy + deleteEnergy);
            continuesCnt = 0;
        }
        useEnergy += Math.min(continuesCnt * deleteEnergy, dragDeleteEnergy + deleteEnergy);
        int maxMakeHYU = Math.min(hCnt, Math.min(uCnt, yCnt));

        sb.append(useEnergy > 0 ? useEnergy : USE_ZERO_ENERGY).append("\n");
        sb.append(maxMakeHYU > 0 ? maxMakeHYU : MAKE_ZERO_HYU).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
