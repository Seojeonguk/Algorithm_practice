import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int studentCnt = Integer.parseInt(br.readLine());
        int software = 0, embedded = 0, ai = 0, first = 0;
        while (studentCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int studentGrade = Integer.parseInt(st.nextToken());
            int studentClass = Integer.parseInt(st.nextToken());
            int studentNum = Integer.parseInt(st.nextToken());

            if (studentGrade == 1) first++;
            else if (studentClass < 3) software++;
            else if (studentClass == 3) embedded++;
            else if (studentClass == 4) ai++;
        }
        sb.append(software).append("\n")
                .append(embedded).append("\n")
                .append(ai).append("\n")
                .append(first).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
