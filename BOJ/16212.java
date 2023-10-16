import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int arrLength = Integer.parseInt(br.readLine());
        int[] arr = new int[arrLength];

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < arrLength; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int idx = 0; idx < arrLength; idx++) {
            sb.append(arr[idx]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
