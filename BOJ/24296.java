import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int personCnt = Integer.parseInt(br.readLine());

        for (int start = 2; start <= personCnt; start++) {
            int currentPerson = start;
            while (currentPerson < personCnt) {
                currentPerson += currentPerson - 1;
            }

            if (currentPerson == personCnt) {
                sb.append(start);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
