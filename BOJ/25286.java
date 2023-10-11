import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            boolean isLeapYear = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
            int prevMonth = (month - 2 + 12) % 12;
            int lastDay = days[prevMonth];
            if (month == 3 && isLeapYear) {
                lastDay++;
            } else if (month == 1) {
                year--;
            }
            sb.append(String.format("%d %d %d\n", year, prevMonth + 1, lastDay));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
