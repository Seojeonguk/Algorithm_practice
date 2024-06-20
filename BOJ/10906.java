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

            int n = Integer.parseInt(br.readLine());

            int[][] first = new int[n][2];
            int[][] second = new int[n][2];

            StringTokenizer firstInfo = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                first[i][0] = Integer.parseInt(firstInfo.nextToken());
                first[i][1] = Integer.parseInt(firstInfo.nextToken());
            }

            StringTokenizer secondInfo = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                second[i][0] = Integer.parseInt(secondInfo.nextToken());
                second[i][1] = Integer.parseInt(secondInfo.nextToken());
            }

            sb.append(getNOrthotope(n, first, second));

            bw.write(sb.toString());
        }
    }

    public static int getNOrthotope(int n, int[][] first, int[][] second) {
        int fullCnt = 0;
        for (int i = 0; i < n; i++) {
            int common = getCommon(first[i][0], first[i][1], second[i][0], second[i][1]);

            if (common == -1) {
                return -1;
            } else if (common > 0) {
                fullCnt++;
            }
        }

        return fullCnt;
    }

    public static int getCommon(int sx, int sy, int ex, int ey) {
        if (ey < sy) {
            int tmp = sx;
            sx = ex;
            sy = ey;
            ex = tmp;
        }

        if (ex > sy) {
            return -1;
        } else if (ex <= sx) {
            return sy - sx;
        } else {
            return sy - ex;
        }
    }
}
