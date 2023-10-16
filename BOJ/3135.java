import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int currentFrequency = Integer.parseInt(st.nextToken());
        int targetFrequency = Integer.parseInt(st.nextToken());

        int minButtonClick = Math.abs(currentFrequency - targetFrequency);
        int favoriteFrequencyCnt = Integer.parseInt(br.readLine());
        while (favoriteFrequencyCnt-- > 0) {
            int favoriteFrequency = Integer.parseInt(br.readLine());
            minButtonClick = Math.min(minButtonClick, Math.abs(favoriteFrequency - targetFrequency) + 1);
        }
        sb.append(minButtonClick);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
