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

            int peakCnt = Integer.parseInt(br.readLine());
            long[][] coordinates = new long[peakCnt][2];
            for (int i = 0; i < peakCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coordinates[i][0] = Long.parseLong(st.nextToken());
                coordinates[i][1] = Long.parseLong(st.nextToken());
            }

            int triangleCnt = 0;
            for (int i = 0; i < peakCnt; i++) {
                for (int j = i + 1; j < peakCnt; j++) {
                    for (int k = j + 1; k < peakCnt; k++) {
                        if (isTriangle(coordinates[i], coordinates[j], coordinates[k])) {
                            triangleCnt++;
                        }
                    }
                }
            }

            sb.append(triangleCnt);

            bw.write(sb.toString());
        }
    }

    public static boolean isTriangle(long[] a, long[] b, long[] c) {
        long abDiff = pow(a[0] - b[0]) + pow(a[1] - b[1]);
        long bcDiff = pow(b[0] - c[0]) + pow(b[1] - c[1]);
        long acDiff = pow(a[0] - c[0]) + pow(a[1] - c[1]);
        long max = Math.max(abDiff, Math.max(bcDiff, acDiff));
        return abDiff + bcDiff + acDiff - max == max;
    }

    public static long pow(long n) {
        return n * n;
    }
}
