import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int studentCnt = Integer.parseInt(br.readLine());
        int[] forecastings = new int[studentCnt];
        for (int student = 0; student < studentCnt; student++) {
            forecastings[student] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(forecastings);

        long dissatisfaction = 0;
        for (int student = 0; student < studentCnt; student++) {
            dissatisfaction += Math.abs(student + 1 - forecastings[student]);
        }
        sb.append(dissatisfaction);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
