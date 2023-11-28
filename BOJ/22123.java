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
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int testTime = Integer.parseInt(st.nextToken());

            int startSecond = calStrToSecond(start);
            int endSecond = calStrToSecond(end);

            if (startSecond >= endSecond) {
                endSecond += 60 * 60 * 24;
            }

            int realEndSecond = startSecond + testTime * 60;
            int testSecond = endSecond + 60 * 60;

            if (realEndSecond <= endSecond) {
                sb.append("Perfect");
            } else if (realEndSecond <= testSecond) {
                sb.append("Test");
            } else {
                sb.append("Fail");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calStrToSecond(String str) {
        String[] strSplit = str.split(":");

        int second = 0;
        second += Integer.parseInt(strSplit[0]) * 60 * 60;
        second += Integer.parseInt(strSplit[1]) * 60;
        second += Integer.parseInt(strSplit[2]);

        return second;
    }
}
