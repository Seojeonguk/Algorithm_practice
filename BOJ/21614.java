import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int previousDirection = 0;
        while (true) {
            int digits = Integer.parseInt(br.readLine());
            if (digits == 99999) {
                break;
            }
            int sumOfFrontTwoDigits = digits / 10000 + digits % 10000 / 1000;

            int direction = (sumOfFrontTwoDigits == 0 ? previousDirection : sumOfFrontTwoDigits % 2 == 1 ? -1 : 1);

            sb.append(direction == 1 ? "right" : "left").append(" ").append(digits % 1000).append("\n");

            previousDirection = direction;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
