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
        int length = Integer.parseInt(br.readLine());
        int[] appearedCnt = new int[4];

        String dirs = br.readLine();
        for (int i = 0; i < length; i++) {
            char dir = dirs.charAt(i);
            if (dir == 'N') {
                appearedCnt[0]++;
            } else if (dir == 'S') {
                appearedCnt[1]++;
            } else if (dir == 'W') {
                appearedCnt[2]++;
            } else if (dir == 'E') {
                appearedCnt[3]++;
            }
        }

        sb.append(length - Arrays.stream(appearedCnt).max().getAsInt());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
