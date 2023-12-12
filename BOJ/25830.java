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
        String strTime = br.readLine();
        int minute = Integer.parseInt(strTime.split(":")[0]);
        int second = Integer.parseInt(strTime.split(":")[1]);

        int totalSecond = minute * 60 * 60 + second * 60;
        int addedSecond = totalSecond - minute * 60 - second;

        sb.append(String.format("%02d:%02d:%02d", addedSecond / 60 / 60, addedSecond / 60 % 60, addedSecond % 60));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
