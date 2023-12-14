import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalLine = Integer.parseInt(br.readLine());

        while (totalLine-- > 0) {
            char[] str = br.readLine().toCharArray();
            for (int i = 0; i < str.length; i++) {
                char c = str[i];
                char encryptedC = decoded(c);
                sb.append(encryptedC);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char decoded(char c) {
        if (c == 'a') {
            return 'e';
        } else if (c == 'A') {
            return 'E';
        } else if (c == 'e') {
            return 'i';
        } else if (c == 'E') {
            return 'I';
        } else if (c == 'i') {
            return 'o';
        } else if (c == 'I') {
            return 'O';
        } else if (c == 'o') {
            return 'u';
        } else if (c == 'O') {
            return 'U';
        } else if (c == 'u') {
            return 'y';
        } else if (c == 'U') {
            return 'Y';
        } else if (c == 'y') {
            return 'a';
        } else if (c == 'Y') {
            return 'A';
        }
        return c;
    }
}
