import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        double seedCost = Double.parseDouble(br.readLine());
        int lawnCnt = Integer.parseInt(br.readLine());

        double totalCost = 0;
        for (int i = 0; i < lawnCnt; i++) {
            st = new StringTokenizer(br.readLine());
            double width = Double.parseDouble(st.nextToken());
            double length = Double.parseDouble(st.nextToken());

            totalCost += width * length * seedCost;
        }

        sb.append(String.format("%.7f", totalCost));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
