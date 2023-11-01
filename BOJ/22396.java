import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());

            int ru = Integer.parseInt(st.nextToken());
            int water = Integer.parseInt(st.nextToken());
            int concentration = Integer.parseInt(st.nextToken());
            int gram = Integer.parseInt(st.nextToken());

            if (ru == 0 && water == 0 && concentration == 0 && gram == 0) {
                break;
            }

            int requiredRu = Math.max(0, concentration * water - ru);
            sb.append(requiredRu / gram + (requiredRu % gram > 0 ? 1 : 0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
