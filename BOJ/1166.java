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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int boxCnt = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.min(length, Math.min(width, height));

        while (Double.compare(left, right) < 0) {
            double mid = (left + right) / 2;

            long l = (long) (length / mid) * (long) (width / mid) * (long) (height / mid);
            if (l < boxCnt) {
                if (Double.compare(right, mid) == 0) {
                    break;
                }
                right = mid;
            } else {
                if (Double.compare(left, mid) == 0) {
                    break;
                }
                left = mid;
            }
        }

        sb.append(left);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
