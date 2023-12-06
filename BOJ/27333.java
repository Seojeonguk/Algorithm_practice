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
        int strLength = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        for (int i = 0; i < strLength - 1; i++) {
            if (str[i] == str[i + 1]) {
                str[i] = str[i + 1] = Character.toUpperCase(str[i]);
            }
        }

        sb.append(str);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
