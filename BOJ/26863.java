import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int TABLE_LEG_COUNT = 4;

    public static void main(String[] args) throws Exception {
        int[] tableLegs = new int[TABLE_LEG_COUNT];
        for (int tableLeg = 0; tableLeg < TABLE_LEG_COUNT; tableLeg++) {
            tableLegs[tableLeg] = Integer.parseInt(br.readLine());
        }

        int pad = Integer.parseInt(br.readLine());

        Arrays.sort(tableLegs);

        if (tableLegs[0] == tableLegs[3] || (tableLegs[0] + pad == tableLegs[1] && tableLegs[1] == tableLegs[2] && tableLegs[2] == tableLegs[3])) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
