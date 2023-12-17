import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        int[][] lights = new int[rowSize + 1][colSize + 1];
        int[][] prefixSums = new int[rowSize + 1][colSize + 1];
        for (int row = 1; row <= rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= colSize; col++) {
                lights[row][col] = Integer.parseInt(st.nextToken());
                prefixSums[row][col] = lights[row][col] + prefixSums[row - 1][col] + prefixSums[row][col - 1] - prefixSums[row - 1][col - 1];
            }
        }

        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int top = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            int size = (bottom - top + 1) * (right - left + 1);
            int sum = prefixSums[bottom][right] - prefixSums[bottom][left - 1] - prefixSums[top - 1][right] + prefixSums[top - 1][left - 1];

            sb.append(sum / size).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
