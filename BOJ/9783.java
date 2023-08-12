import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        String originalMessage = br.readLine();

        for (int idx = 0; idx < originalMessage.length(); idx++) {
            String encryptionChar = getEncryption(originalMessage.charAt(idx));
            sb.append(encryptionChar);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String getEncryption(char c) {
        String str = Character.toString(c);
        if (Character.isDigit(c)) {
            str = String.format("#%d", c - '0');
        } else if (Character.isUpperCase(c)) {
            str = Integer.toString(c - 'A' + 27);
        } else if (Character.isLowerCase(c)) {
            str = String.format("%02d", c - 'a' + 1);
        }

        return str;
    }
}
