import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int buildingCnt = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] visibleBuildingCnt = new int[buildingCnt];

        for (int i = 0; i < buildingCnt; i++) {
            double maxSlope = -99999999999.0;

            for (int j = i + 1; j < buildingCnt; j++) {
                double slope = (double) (heights[j] - heights[i]) / (j - i);
                if (maxSlope < slope) {
                    maxSlope = slope;
                    visibleBuildingCnt[i]++;
                    visibleBuildingCnt[j]++;
                }
            }
        }

        sb.append(Arrays.stream(visibleBuildingCnt).max().getAsInt());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
