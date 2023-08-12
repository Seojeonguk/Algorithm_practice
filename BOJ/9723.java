import java.math.MathContext;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            st = new StringTokenizer(br.readLine());

            int[] triangleSideLengths = new int[3];
            for (int i = 0; i < 3; i++) {
                triangleSideLengths[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(triangleSideLengths);

            boolean isRight = (getExponentiation(triangleSideLengths[2], 2) == getExponentiation(triangleSideLengths[0], 2) + getExponentiation(triangleSideLengths[1], 2));

            sb.append(String.format("Case #%d: %s\n", testCase, isRight ? "YES" : "NO"));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getExponentiation(int base, int exponent) {
        int ret = 1;
        for (int i = 0; i < exponent; i++) {
            ret *= base;
        }
        return ret;
    }
}
