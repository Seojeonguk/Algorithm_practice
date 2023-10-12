import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            double originalPrice = Double.parseDouble(st.nextToken());
            double relativeChange = Double.parseDouble(st.nextToken());

            sb.append(100.0f * originalPrice / (100.0f + relativeChange)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
