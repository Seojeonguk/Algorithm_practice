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

        StringTokenizer bannerInfo = new StringTokenizer(br.readLine());
        int stakeCnt = Integer.parseInt(bannerInfo.nextToken());
        int flagpoleCnt = Integer.parseInt(bannerInfo.nextToken());
        int maxBannerArea = Integer.parseInt(bannerInfo.nextToken());

        int[] stakes = new int[stakeCnt];
        StringTokenizer stakeInfo = new StringTokenizer(br.readLine());
        for (int stakeNum = 0; stakeNum < stakeCnt; stakeNum++) {
            stakes[stakeNum] = Integer.parseInt(stakeInfo.nextToken());
        }

        Arrays.sort(stakes);

        int[] flagpoles = new int[flagpoleCnt];
        StringTokenizer flagpoleInfo = new StringTokenizer(br.readLine());
        for (int flagpoleNum = 0; flagpoleNum < flagpoleCnt; flagpoleNum++) {
            flagpoles[flagpoleNum] = Integer.parseInt(flagpoleInfo.nextToken());
        }

        Arrays.sort(flagpoles);

        int bannerArea = calBannerArea(stakes, flagpoles, maxBannerArea);
        if (bannerArea == -1) {
            sb.append(-1);
        } else {
            sb.append(bannerArea / 2).append(".").append(bannerArea % 2 == 0 ? 0 : 5);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calBannerArea(int[] stakes, int[] flagpoles, int maxBannerArea) {
        int bannerArea = -1;

        for (int i = 0; i < stakes.length; i++) {
            for (int j = i + 1; j < stakes.length; j++) {
                int baseLine = Math.abs(stakes[j] - stakes[i]);

                if (baseLine >= maxBannerArea * 2) {
                    break;
                }

                int idx = binarySearch(flagpoles, baseLine, maxBannerArea);
                int area = baseLine * flagpoles[idx];
                if (area > maxBannerArea * 2) {
                    continue;
                }

                bannerArea = Math.max(bannerArea, area);
            }
        }

        return bannerArea;
    }

    public static int binarySearch(int[] flagpoles, int baseLine, int maxBannerArea) {
        int left = 0;
        int right = flagpoles.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            int area = baseLine * flagpoles[middle];
            if (area <= maxBannerArea * 2) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return Math.max(left - 1, 0);
    }
}
