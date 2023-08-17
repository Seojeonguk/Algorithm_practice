import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[] years = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void main(String[] args) throws Exception {
        for (int tc = 1; ; tc++) {
            st = new StringTokenizer(br.readLine());
            int birthdayCnt = Integer.parseInt(st.nextToken());
            if (birthdayCnt == 0) {
                break;
            }
            int[] birthdaysCnt = new int[12];
            for (int i = 0; i < birthdayCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int birthDay = Integer.parseInt(st.nextToken());
                int birthMonth = Integer.parseInt(st.nextToken());
                int birthYear = Integer.parseInt(st.nextToken());

                birthdaysCnt[birthMonth - 1]++;
            }
            sb.append(String.format("Case #%d:\n", tc));
            for (int i = 0; i < 12; i++) {
                sb.append(years[i]).append(":");
                for (int j = 0; j < birthdaysCnt[i]; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
