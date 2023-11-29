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
            int redPileCnt = Integer.parseInt(st.nextToken());
            int whitePileCnt = Integer.parseInt(st.nextToken());
            long sumRed = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();
            long sumWhite = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();

            sb.append(redPileCnt <= whitePileCnt ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
