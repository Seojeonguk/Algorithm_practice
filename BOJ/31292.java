import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer xInfo = new StringTokenizer(br.readLine());
        StringTokenizer yInfo = new StringTokenizer(br.readLine());

        int xCnt = Integer.parseInt(xInfo.nextToken());
        int yCnt = Integer.parseInt(yInfo.nextToken());

        int[] x = new int[xCnt + 1];
        int[] y = new int[yCnt + 1];
        for (int i = 0; i < xCnt + 1; i++) {
            x[i] = Integer.parseInt(xInfo.nextToken());
        }
        for (int i = 0; i < yCnt + 1; i++) {
            y[i] = Integer.parseInt(yInfo.nextToken());
        }

        int res = compare(x, y);
        if (res == -1) {
            sb.append(">");
        } else if (res == 1) {
            sb.append("<");
        } else {
            sb.append("=");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int compare(int[] x, int[] y) {
        int minIdx = Math.min(x.length, y.length);
        for (int i = 0; i < minIdx; i++) {
            if (x[i] != y[i]) {
                int res = (i % 2 == 0 ? 1 : -1) * (x[i] - y[i]);
                return (res < 0 ? 1 : -1);
            }
        }

        if (x.length == y.length) {
            return 0;
        }

        return (minIdx % 2 == 0 ? 1 : -1) * (x.length < y.length ? -1 : 1);
    }
}
