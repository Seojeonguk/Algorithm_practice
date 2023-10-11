import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char[] str2 = str.toCharArray();
        boolean existLetter = false;
        for (int i = 0; i < str2.length; i++) {
            if (!Character.isDigit(str2[i]) && str2[i] != ' ') {
                existLetter = true;
                break;
            }
        }

        String ans = "NaN";
        if (!existLetter) {
            String[] splitedStr = str.split(" ");
            int x = Integer.parseInt(splitedStr[0]);
            int y = Integer.parseInt(splitedStr[1]);

            ans = String.valueOf(x - y);
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
