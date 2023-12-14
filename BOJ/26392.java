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
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {
            int maxRow = 0, minRow = rowSize - 1;
            for (int i = 0; i < rowSize; i++) {
                String NFP = br.readLine();
                if (NFP.contains("#")) {
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                }
            }
            sb.append(Math.abs(maxRow - minRow)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
