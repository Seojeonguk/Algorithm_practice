import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int NUM = 4;

    public static void main(String[] args) throws Exception {
        int[] arr = new int[NUM];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < NUM; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sb.append(String.format("%d %d %d %d", arr[0], arr[2], arr[1], arr[3]));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
