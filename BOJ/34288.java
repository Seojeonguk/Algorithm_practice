import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int meter = Integer.parseInt(st.nextToken());
        int acceleration = Integer.parseInt(st.nextToken());

        boolean isImpossibleTrack = false;

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[meter + 1];
        for (int i = 0; i < meter + 1; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < meter + 1; i++) {
            if (heights[i - 1] < heights[i]) {
                isImpossibleTrack |= (Math.abs(heights[i - 1] - heights[i]) > acceleration);
            }
        }

        sb.append(isImpossibleTrack ? "BUG REPORT" : "POSSIBLE");

        bw.write(sb.toString());
        bw.flush();
    }
}
