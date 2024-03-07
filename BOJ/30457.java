import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_HEIGHT = 1000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int studentCnt = Integer.parseInt(br.readLine());
        int[] heights = new int[studentCnt];
        StringTokenizer heightInfo = new StringTokenizer(br.readLine());

        int[] appearedHeights = new int[MAX_HEIGHT + 1];

        for (int idx = 0; idx < studentCnt; idx++) {
            heights[idx] = Integer.parseInt(heightInfo.nextToken());
            appearedHeights[heights[idx]]++;
        }

        int maxParticipateStudent = 0;
        for (int height = 1; height <= MAX_HEIGHT; height++) {
            maxParticipateStudent += Math.min(appearedHeights[height], 2);
        }

        sb.append(maxParticipateStudent);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
