import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = "";
        PriorityQueue<Long> pq = new PriorityQueue<>();
        boolean first = false;
        while ((str = br.readLine()) != null) {
            if(str.equals("")) {
                continue;
            }
            st = new StringTokenizer(str);
            while (st.hasMoreElements()) {
                String reverseS = new StringBuilder(st.nextToken()).reverse().toString();
                long reverseValue = Long.parseLong(reverseS);
                if (!first) {
                    first = true;
                    continue;
                }
                pq.add(reverseValue);
            }
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
