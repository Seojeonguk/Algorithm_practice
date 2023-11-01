import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String money;
        long sumNum = 0, sumDecimal = 0;
        while ((money = br.readLine()) != null && !money.equals("")) {
            String[] moneys = money.split("\\.");
            sumNum += Long.parseLong(moneys[0]);
            sumDecimal += Long.parseLong(moneys[1]);
        }

        sb.append(String.format("%d.%02d", sumNum + sumDecimal / 100, sumDecimal % 100));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
