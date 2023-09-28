import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int blackHoleCnt = Integer.parseInt(st.nextToken());
        int asteroidCnt = Integer.parseInt(st.nextToken());

        int[] blackHolePlace = new int[blackHoleCnt];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < blackHoleCnt; idx++) {
            blackHolePlace[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(blackHolePlace);
        int maxP = 0;
        for (int idx = 0; idx < asteroidCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int place = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            int lo = lowerBound(blackHolePlace, place);
            
            int minDiff = Math.abs(place - blackHolePlace[lo]);
            if (lo > 0) {
                minDiff = Math.min(minDiff, Math.abs(place - blackHolePlace[lo - 1]));
            }
            maxP = Math.max(maxP, minDiff * weight);
        }

        sb.append(maxP);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int lowerBound(int[] blackHole, int place) {
        int left = 0, right = blackHole.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (blackHole[mid] < place) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
