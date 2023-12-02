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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int firstDistanceMeter = Integer.parseInt(st.nextToken());
        int secondDistanceMeter = Integer.parseInt(st.nextToken());

        int firstMinPrice = calMinPrice(firstDistanceMeter);
        int secondMinPrice = calMinPrice(secondDistanceMeter);

        int totalMinPrice = firstMinPrice + secondMinPrice;

        sb.append(String.format("%d.%02d", totalMinPrice / 100, totalMinPrice % 100));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMinPrice(int distanceMeter) {
        int distanceKiloMeter = distanceMeter / 1000;
        int firstIndustryPrice = 0;
        if (distanceKiloMeter <= 5) {
            firstIndustryPrice = 400;
        } else if (distanceKiloMeter <= 10) {
            firstIndustryPrice = 700;
        } else if (distanceKiloMeter <= 20) {
            firstIndustryPrice = 1200;
        } else if (distanceKiloMeter <= 30) {
            firstIndustryPrice = 1700;
        } else {
            firstIndustryPrice = distanceKiloMeter * 57;
        }

        int secondIndustryPrice = 0;
        if (distanceKiloMeter <= 2) {
            secondIndustryPrice = 90 + distanceKiloMeter * 90;
        } else if (distanceKiloMeter <= 5) {
            secondIndustryPrice = 100 + distanceKiloMeter * 85;
        } else if (distanceKiloMeter <= 20) {
            secondIndustryPrice = 125 + distanceKiloMeter * 80;
        } else if (distanceKiloMeter <= 40) {
            secondIndustryPrice = 325 + distanceKiloMeter * 70;
        } else {
            secondIndustryPrice = 925 + distanceKiloMeter * 55;
        }

        int minPrice = Math.min(firstIndustryPrice, secondIndustryPrice);
        return minPrice;
    }
}
