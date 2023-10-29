import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int birthdayCnt = Integer.parseInt(br.readLine());
        HashSet<String> birthdays = new HashSet<>();

        while (birthdayCnt-- > 0) {
            String birthday = br.readLine();
            birthdays.add(birthday);
        }

        sb.append(birthdays.size());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
