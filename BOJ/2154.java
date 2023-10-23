import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int findNumber = Integer.parseInt(br.readLine());
        String strFindNumber = String.valueOf(findNumber);

        StringBuilder continueNumber = new StringBuilder();
        for (int i = 1; i <= findNumber; i++) {
            continueNumber.append(i);
        }

        int findIndex = continueNumber.indexOf(strFindNumber);
        sb.append(findIndex + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
