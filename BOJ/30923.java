import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        long totalSurfaceArea = 2 * n;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            totalSurfaceArea += heights[i] * 2;
        }

        totalSurfaceArea += heights[0] + heights[n - 1];
        for (int i = 0; i < n - 1; i++) {
            totalSurfaceArea += Math.abs(heights[i] - heights[i + 1]);
        }

        sb.append(totalSurfaceArea);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
