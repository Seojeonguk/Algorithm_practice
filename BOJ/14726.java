import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String cardNum = br.readLine();
            int sum = 0;
            for (int cardIdx = 0; cardIdx < cardNum.length(); cardIdx++) {
                if (cardIdx % 2 == 0) {
                    int num = cardNum.charAt(cardIdx) - '0';
                    num *= 2;
                    if (num >= 10) {
                        num = num / 10 + num % 10;
                    }
                    sum += num;
                } else {
                    sum += cardNum.charAt(cardIdx) - '0';
                }
            }
            sb.append(sum % 10 == 0 ? "T" : "F").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
