import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int level = Integer.parseInt(br.readLine());

        int medicine = 4;
        int maxLevel = level + 1;

        int first = Math.min(210, level + 8);
        int second = Math.min(220, level + 4);
        int third = Math.min(230, level + 2);

        if (maxLevel < third) {
            maxLevel = third;
            medicine = 3;
        }
        if (maxLevel < second) {
            maxLevel = second;
            medicine = 2;
        }
        if (maxLevel < first) {
            maxLevel = first;
            medicine = 1;
        }

        sb.append(medicine);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
