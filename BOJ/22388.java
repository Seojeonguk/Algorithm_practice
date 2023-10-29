import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            String strDate = br.readLine();
            if ("#".equals(strDate)) {
                break;
            }
            String[] date = strDate.split(" ");
            int year = Integer.parseInt(date[1]);
            int month = Integer.parseInt(date[2]);
            int day = Integer.parseInt(date[3]);

            sb.append(year > 31 || (year == 31 && month >= 5) ? "?" : "HEISEI").append(" ")
                    .append(year > 31 || (year == 31 && month >= 5) ? year - 30 : year).append(" ")
                    .append(month).append(" ")
                    .append(day).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
