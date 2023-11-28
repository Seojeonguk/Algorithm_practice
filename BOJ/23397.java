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

        int minRestTime = Integer.parseInt(st.nextToken());
        int flightTime = Integer.parseInt(st.nextToken());
        int flightMealCnt = Integer.parseInt(st.nextToken());

        int[] flightMeals = new int[flightMealCnt + 2];
        flightMeals[flightMealCnt + 1] = flightTime;
        for (int i = 1; i <= flightMealCnt; i++) {
            flightMeals[i] = Integer.parseInt(br.readLine());
        }

        int maxRestTime = 0;
        for (int i = 1; i <= flightMealCnt + 1; i++) {
            int restTime = flightMeals[i] - flightMeals[i - 1];
            maxRestTime = Math.max(maxRestTime, restTime);
        }

        sb.append(maxRestTime >= minRestTime ? "Y" : "N");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
