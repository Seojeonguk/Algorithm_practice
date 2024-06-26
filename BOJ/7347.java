import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int length = Integer.parseInt(st.nextToken());
                int[] tracks = new int[length];
                for (int i = 0; i < length; i++) {
                    tracks[i] = Integer.parseInt(st.nextToken());
                }

                sb.append(canDivide(tracks) ? "YES" : "NO").append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean canDivide(int[] tracks) {
        if (tracks.length % 2 == 1) {
            return true;
        }

        int evenCnt = 0, oddCnt = 0;
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] == 1) {
                continue;
            }

            if (i % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        return Math.abs(evenCnt - oddCnt) <= 1;
    }
}
