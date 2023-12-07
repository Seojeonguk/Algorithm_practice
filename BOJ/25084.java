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

    static final double PI = 3.14159265358979323d;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int radius = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int curRadius = radius;
            double sumCircleArea = 0;
            boolean isA = true;

            while (curRadius > 0) {
                sumCircleArea += PI * curRadius * curRadius;
                if (isA) {
                    curRadius *= a;
                } else {
                    curRadius /= b;
                }
                isA = !isA;
            }


            sb.append("Case #").append(tc).append(": ").append(sumCircleArea).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
