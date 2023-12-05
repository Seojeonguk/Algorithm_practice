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
        long dayPerMonth = Long.parseLong(st.nextToken());
        long MonthPerYear = Long.parseLong(st.nextToken());
        long dayPerWeek = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long day = Long.parseLong(st.nextToken());
        long month = Long.parseLong(st.nextToken());
        long year = Long.parseLong(st.nextToken());

        sb.append((char) (((year - 1) * MonthPerYear * dayPerMonth + (month - 1) * dayPerMonth + (day - 1)) % dayPerWeek + 'a'));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
