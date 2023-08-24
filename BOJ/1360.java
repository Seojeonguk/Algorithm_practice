import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean[] isCancel = new boolean[n];
        String[] commands = new String[n];
        String[] values = new String[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i] = st.nextToken();
            values[i] = st.nextToken();
            times[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            if ("type".equals(commands[i]) || isCancel[i]) {
                continue;
            }
            isCancel[i] = true;
            int time = Integer.parseInt(values[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (times[i] - time > times[j]) {
                    break;
                }
                isCancel[j] = !isCancel[j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isCancel[i]) {
                sb.append(values[i]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
