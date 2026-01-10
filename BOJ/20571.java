import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    private static final int[] RESIDENTIAL_ELEVATORS = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    private static final int[] COMMERCIAL_ELEVATORS = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3};
    private static final int[] INDUSTRIAL_ELEVATORS = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5};

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String building = st.nextToken();
        int floor = Integer.parseInt(st.nextToken());

        if ("residential".equals(building)) {
            sb.append(RESIDENTIAL_ELEVATORS[floor]);
        } else if ("commercial".equals(building)) {
            sb.append(COMMERCIAL_ELEVATORS[floor]);
        } else {
            sb.append(INDUSTRIAL_ELEVATORS[floor]);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
