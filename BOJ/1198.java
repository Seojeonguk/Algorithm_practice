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

        int dotCnt = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[dotCnt][2];
        for (int dot = 0; dot < dotCnt; dot++) {
            StringTokenizer coordinate = new StringTokenizer(br.readLine());
            coordinates[dot][0] = Integer.parseInt(coordinate.nextToken());
            coordinates[dot][1] = Integer.parseInt(coordinate.nextToken());
        }

        double maxArea = 0;
        for (int i = 0; i < dotCnt; i++) {
            for (int j = i + 1; j < dotCnt; j++) {
                for (int k = j + 1; k < dotCnt; k++) {
                    double area = calArea(coordinates[i], coordinates[j], coordinates[k]);
                    if (maxArea < area) {
                        maxArea = area;
                    }
                }
            }
        }

        sb.append(maxArea);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static double calArea(int[] a, int[] b, int[] c) {
        int l = a[0] * b[1] + b[0] * c[1] + c[0] * a[1];
        int r = b[0] * a[1] + c[0] * b[1] + a[0] * c[1];

        return (Math.abs(l - r) / 2.0);
    }
}
