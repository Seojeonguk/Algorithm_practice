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
        st = new StringTokenizer(br.readLine());
        int firstDay = Integer.parseInt(st.nextToken());
        int firstMonth = Integer.parseInt(st.nextToken());
        int firstYear = Integer.parseInt(st.nextToken());
        int firstDayOfWeek = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int secondDay = Integer.parseInt(st.nextToken());
        int secondMonth = Integer.parseInt(st.nextToken());
        int secondYear = Integer.parseInt(st.nextToken());

        int totalFirstDay = firstDay + firstMonth * 30 + firstYear * 30 * 12;
        int totalSecondDay = secondDay + secondMonth * 30 + secondYear * 30 * 12;

        int changedDay = (totalSecondDay - totalFirstDay) % 7;

        sb.append((firstDayOfWeek - 1 + changedDay) % 7 + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
