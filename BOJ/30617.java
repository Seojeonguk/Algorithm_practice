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
        int songLength = Integer.parseInt(br.readLine());
        int[][] noves = new int[songLength][2];

        int funny = 0;
        for (int i = 0; i < songLength; i++) {
            st = new StringTokenizer(br.readLine());
            noves[i][0] = Integer.parseInt(st.nextToken());
            noves[i][1] = Integer.parseInt(st.nextToken());

            if (i > 0) {
                if (noves[i][0] != 0 && noves[i - 1][0] == noves[i][0]) {
                    funny++;
                }
                if (noves[i][1] != 0 && noves[i - 1][1] == noves[i][1]) {
                    funny++;
                }
            }

            if (noves[i][0] != 0 && noves[i][0] == noves[i][1]) {
                funny++;
            }
        }

        sb.append(funny);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
