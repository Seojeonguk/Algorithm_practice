import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int happinessPerMilk = Integer.parseInt(st.nextToken());
        int happinessPerHoney = Integer.parseInt(st.nextToken());

        int fieldCnt = Integer.parseInt(br.readLine());
        int maxHappiness = 0;
        for (int field = 0; field < fieldCnt; field++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int bee = Integer.parseInt(st.nextToken());
            maxHappiness += Math.max(cow * happinessPerMilk, bee * happinessPerHoney);
        }
        sb.append(maxHappiness);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
