import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        int[] arr = new int[3];

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if (arr[0] + arr[1] == arr[2] || arr[2] - arr[1] == arr[0] || arr[0] * arr[1] == arr[2]) {
                sb.append("Possible");
            } else {
                sb.append("Impossible");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
