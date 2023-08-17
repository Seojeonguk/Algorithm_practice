import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int testCase = Integer.parseInt(br.readLine());
            if (testCase == 0) {
                break;
            }

            for (int tc = 0; tc < testCase; tc++) {
                st = new StringTokenizer(br.readLine());

                int under127Cnt = 0;
                int under127Idx = 0;
                for (int i = 0; i < 5; i++) {
                    int color = Integer.parseInt(st.nextToken());
                    if (color <= 127) {
                        under127Cnt++;
                        under127Idx = i;
                    }
                }

                if (under127Cnt != 1) {
                    sb.append("*").append("\n");
                } else {
                    sb.append(Character.toChars('A' + under127Idx)).append("\n");
                }
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
