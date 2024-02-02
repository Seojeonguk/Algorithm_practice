import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalLogDay = Integer.parseInt(st.nextToken());
        int minimumDrinkCupOfWaterOnAnyDay = Integer.parseInt(st.nextToken());
        int maximumDrinkCupOfWaterOnAnyDay = Integer.parseInt(st.nextToken());
        boolean existMinimumDrink = false;
        boolean existMaximumDrink = false;

        int[] logs = new int[totalLogDay - 1];
        for (int i = 0; i < totalLogDay - 1; i++) {
            logs[i] = Integer.parseInt(br.readLine());
            if (logs[i] == minimumDrinkCupOfWaterOnAnyDay) {
                existMinimumDrink = true;
            }
            if (logs[i] == maximumDrinkCupOfWaterOnAnyDay) {
                existMaximumDrink = true;
            }
        }

        if (existMinimumDrink && existMaximumDrink) {
            for (int i = minimumDrinkCupOfWaterOnAnyDay; i <= maximumDrinkCupOfWaterOnAnyDay; i++) {
                sb.append(i).append("\n");
            }
        } else if (existMinimumDrink) {
            sb.append(maximumDrinkCupOfWaterOnAnyDay);
        } else if (existMaximumDrink) {
            sb.append(minimumDrinkCupOfWaterOnAnyDay);
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
