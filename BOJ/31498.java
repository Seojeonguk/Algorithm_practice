import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer tocaInfo = new StringTokenizer(br.readLine());
        long a = Long.parseLong(tocaInfo.nextToken());
        long b = Long.parseLong(tocaInfo.nextToken());

        StringTokenizer doldolInfo = new StringTokenizer(br.readLine());
        long c = Long.parseLong(doldolInfo.nextToken());
        long d = Long.parseLong(doldolInfo.nextToken());

        long k = Long.parseLong(br.readLine());

        sb.append(calStepArrivingHomeSafely(a, b, c, d, k));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calStepArrivingHomeSafely(long tocaInitLocation, long tocaInitMovedDistance, long doldolInitLocationFromToca, long doldolInitMovedDistance, long decreasingMovedDistance) {
        if (decreasingMovedDistance == 0) {
            long step = (tocaInitLocation + tocaInitMovedDistance - 1) / tocaInitMovedDistance;
            long doldolDistance = tocaInitLocation + doldolInitLocationFromToca - doldolInitMovedDistance * step;

            return (doldolDistance > 0 ? step : -1);
        }

        long tocaArrivalTime = calArrivalTime(tocaInitLocation, tocaInitMovedDistance, decreasingMovedDistance);
        if (tocaArrivalTime == -1) {
            return -1;
        }

        for (long step = 1; step <= tocaArrivalTime; step++) {
            long tocaMovedDistance = (step * (2 * tocaInitMovedDistance - (step - 1) * decreasingMovedDistance)) / 2;
            long doldolMovedDistance = doldolInitMovedDistance * step;

            long tocaLocation = tocaInitLocation - tocaMovedDistance;
            long doldolLocation = tocaInitLocation + doldolInitLocationFromToca - doldolMovedDistance;

            if (tocaLocation >= doldolLocation) {
                return -1;
            }
        }

        return (tocaInitLocation + doldolInitLocationFromToca - doldolInitMovedDistance * tocaArrivalTime <= 0 ? -1 : tocaArrivalTime);
    }

    public static long calArrivalTime(long tocaCurrentLocation, long tocaInitMovedDistance, long decreasingMovedDistance) {
        long left = 1;
        long right = (tocaInitMovedDistance + decreasingMovedDistance - 1) / decreasingMovedDistance;
        long tocaMovedDistance = 0;

        while (left <= right) {
            long middle = (left + right) / 2;

            tocaMovedDistance = (middle * (2 * tocaInitMovedDistance - (middle - 1) * decreasingMovedDistance)) / 2;

            if (tocaCurrentLocation > tocaMovedDistance) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        tocaMovedDistance = (left * (2 * tocaInitMovedDistance - (left - 1) * decreasingMovedDistance)) / 2;

        return (tocaCurrentLocation <= tocaMovedDistance ? left : -1);
    }
}
