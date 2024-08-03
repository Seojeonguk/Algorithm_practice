import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int multiOutletCnt = Integer.parseInt(br.readLine());
            Integer[] sockets = new Integer[multiOutletCnt];
            StringTokenizer socketToken = new StringTokenizer(br.readLine());
            for (int i = 0; i < multiOutletCnt; i++) {
                sockets[i] = Integer.parseInt(socketToken.nextToken());
            }

            sb.append(calMinSockets(sockets));

            bw.write(sb.toString());
        }
    }

    public static int calMinSockets(Integer[] sockets) {
        if (sockets.length == 1) {
            return sockets[0];
        }

        if (sockets.length == 2) {
            return sockets[0] + sockets[1] - 1;
        }

        Arrays.sort(sockets, Collections.reverseOrder());

        int a = 1;
        int b = sockets.length / 3 + 1 + (sockets.length % 3 == 0 ? 0 : 1);
        int c = b + sockets.length / 3 + (sockets.length % 3 == 2 ? 1 : 0);

        return sockets[a - 1] + sockets[b - 1] + sockets[c - 1] - 3;
    }
}
