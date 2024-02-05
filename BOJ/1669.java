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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int monkeyHeight = Integer.parseInt(st.nextToken());
        int dogHeight = Integer.parseInt(st.nextToken());

        int minimumDay = calDayForSameHeight(monkeyHeight, dogHeight);
        sb.append(minimumDay);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calDayForSameHeight(int monkeyHeight, int dogHeight) {
        int heightDiff = dogHeight - monkeyHeight;

        int day = 0;
        while (true) {
            int half = day / 2;

            long maxChangedHeight = (long) (half + (day % 2 == 0 ? 0 : 1)) * (half + 1);
            if (maxChangedHeight >= heightDiff) {
                break;
            }
            day++;
        }

        return day;
    }
}
