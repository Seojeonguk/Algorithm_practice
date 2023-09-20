import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int DAY_PER_MONTH = 30;
    final static int MONTH_PER_YEAR = 12;

    public static void main(String[] args) throws Exception {
        String[] today = br.readLine().split("-");
        int year = Integer.parseInt(today[0]);
        int month = Integer.parseInt(today[1]);
        int day = Integer.parseInt(today[2]);

        int cycle = Integer.parseInt(br.readLine());
        year += cycle / (DAY_PER_MONTH * MONTH_PER_YEAR);
        cycle %= DAY_PER_MONTH * MONTH_PER_YEAR;
        month += cycle / DAY_PER_MONTH;
        cycle %= DAY_PER_MONTH;
        day += cycle;
        if (day > DAY_PER_MONTH) {
            day %= DAY_PER_MONTH;
            month++;
        }
        if (month > MONTH_PER_YEAR) {
            month %= MONTH_PER_YEAR;
            year++;
        }
        sb.append(String.format("%04d-%02d-%02d", year, month, day));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
