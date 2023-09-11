import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int sleepingTime = Integer.parseInt(br.readLine());
        int wakeUpTime = Integer.parseInt(br.readLine());

        sb.append(wakeUpTime + (sleepingTime > 15 ? 24 - sleepingTime : -sleepingTime));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
