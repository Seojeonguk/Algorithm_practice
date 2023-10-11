import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] days = br.readLine().split("-");
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);

        boolean isLate = true;
        if (month < 9 || (month == 9 && day <= 16)) {
            isLate = false;
        }
        sb.append(isLate ? "TOO LATE" : "GOOD");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
