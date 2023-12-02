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
        int travelCnt = Integer.parseInt(br.readLine());

        int firstEven = -1, firstOdd = -1;
        for (int i = 0; i < travelCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (Math.abs(x - y) % 2 == 0) {
                firstEven = i;
            } else {
                firstOdd = i;
            }

            if (firstEven >= 0 && firstOdd >= 0) {
                break;
            }
        }

        if (firstEven >= 0 && firstOdd >= 0) {
            sb.append("YES\n");
            sb.append(firstEven + 1).append(" ");
            for (int i = 0; i < travelCnt; i++) {
                if (i != firstEven && i != firstOdd) {
                    sb.append(i + 1).append(" ");
                }
            }
            sb.append(firstOdd + 1);
        } else {
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
