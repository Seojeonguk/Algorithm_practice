import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());


        for (int testCase = 0; testCase < tc; testCase++) {
            int redSum = 0, greenSum = 0, blueSum = 0;
            for (int i = 0; i < 10; i++) {
                st = new StringTokenizer(br.readLine());
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());

                redSum += red;
                greenSum += green;
                blueSum += blue;
            }

            sb.append((redSum+5) / 10)
                    .append(" ")
                    .append((greenSum+5) / 10)
                    .append(" ")
                    .append((blueSum+5) / 10)
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
