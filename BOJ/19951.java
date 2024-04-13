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
        int militaryGroundSize = Integer.parseInt(st.nextToken());
        int assistantCnt = Integer.parseInt(st.nextToken());

        int[] heights = new int[militaryGroundSize + 1];
        int[] changedHeights = new int[militaryGroundSize + 2];
        StringTokenizer sandInfo = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= militaryGroundSize; idx++) {
            heights[idx] = Integer.parseInt(sandInfo.nextToken());
        }

        for (int assistantNum = 0; assistantNum < assistantCnt; assistantNum++) {
            StringTokenizer instructionInfo = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(instructionInfo.nextToken());
            int end = Integer.parseInt(instructionInfo.nextToken());
            int changedHeight = Integer.parseInt(instructionInfo.nextToken());

            changedHeights[start] += changedHeight;
            changedHeights[end + 1] -= changedHeight;
        }

        int totalChangedHeight = 0;
        for (int idx = 1; idx <= militaryGroundSize; idx++) {
            totalChangedHeight += changedHeights[idx];
            sb.append(heights[idx] + totalChangedHeight).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
