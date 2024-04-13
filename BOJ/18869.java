import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer spaceInfo = new StringTokenizer(br.readLine());
        int universeCnt = Integer.parseInt(spaceInfo.nextToken());
        int planetCnt = Integer.parseInt(spaceInfo.nextToken());

        int[] arr = new int[planetCnt];
        int[][] zips = new int[universeCnt][planetCnt];

        for (int universeNum = 0; universeNum < universeCnt; universeNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int planetNum = 0; planetNum < planetCnt; planetNum++) {
                arr[planetNum] = Integer.parseInt(st.nextToken());
            }

            int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();

            for (int planetNum = 0; planetNum < planetCnt; planetNum++) {
                zips[universeNum][planetNum] = Arrays.binarySearch(sorted, arr[planetNum]);
            }
        }

        int evenUniversePairCnt = 0;
        for (int aUniverseNum = 0; aUniverseNum < universeCnt; aUniverseNum++) {
            for (int bUniverseNum = aUniverseNum + 1; bUniverseNum < universeCnt; bUniverseNum++) {
                if (Arrays.equals(zips[aUniverseNum], zips[bUniverseNum])) {
                    evenUniversePairCnt++;
                }
            }
        }

        sb.append(evenUniversePairCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
