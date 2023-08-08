import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int wordCnt;
    static String[] codedMessage;

    public static void main(String[] args) throws Exception {
        wordCnt = Integer.parseInt(br.readLine());
        codedMessage = br.readLine().split(" ");
        sb.append(codedMessage[0].charAt(0));

        for (int i = 1; i < wordCnt; i++) {
            if (codedMessage[i - 1].length() > codedMessage[i].length()) {
                sb.append(' ');
            } else {
                sb.append(codedMessage[i].charAt(codedMessage[i - 1].length() - 1));
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
