import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MOD = 100000;

    public static void main(String[] args) throws Exception {

        for (int userNum = 1; ; userNum++) {
            st = new StringTokenizer(br.readLine());
            int strideLength = Integer.parseInt(st.nextToken());
            if (strideLength == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());

            sb.append(String.format("User %d\n", userNum));
            for (int i = 0; i < data; i++) {
                st = new StringTokenizer(br.readLine());
                int steps = Integer.parseInt(st.nextToken());
                int walkedDistanceForCentimeter = steps * strideLength;
                double walkedDistanceForKilometer = 1.0f * walkedDistanceForCentimeter / MOD;
                sb.append(String.format("%.5f\n", walkedDistanceForKilometer));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
