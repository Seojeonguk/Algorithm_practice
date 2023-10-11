import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int baseCnt = Integer.parseInt(st.nextToken());
        int floors = Integer.parseInt(st.nextToken());
        long power = Long.parseLong(st.nextToken());

        int[] basePowers = new int[floors];

        boolean possibleMission = true;
        Loop1:
        while (baseCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int itemCnt = 0;
            for (int floor = 0; floor < floors; floor++) {
                basePowers[floor] = Integer.parseInt(st.nextToken());
                if (basePowers[floor] == -1) {
                    itemCnt++;
                }
            }
            Arrays.sort(basePowers);
            for (int floor = itemCnt; floor < floors; floor++) {
                while (itemCnt > 0 && power < basePowers[floor]) {
                    power *= 2L;
                    itemCnt--;
                }
                if (power < basePowers[floor]) {
                    possibleMission = false;
                    break Loop1;
                }
                power += basePowers[floor];
            }
            while (itemCnt > 0) {
                power *= 2L;
                itemCnt--;
            }
        }

        sb.append(possibleMission ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
