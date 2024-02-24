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

        StringTokenizer songInfo = new StringTokenizer(br.readLine());
        int noteCnt = Integer.parseInt(songInfo.nextToken());
        int queryCnt = Integer.parseInt(songInfo.nextToken());

        int[] notes = new int[noteCnt + 1];
        int[] prefixSum = new int[noteCnt + 1];
        for (int noteNum = 1; noteNum <= noteCnt; noteNum++) {
            notes[noteNum] = Integer.parseInt(br.readLine());
            prefixSum[noteNum] = prefixSum[noteNum - 1] + notes[noteNum];
        }

        for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
            int time = Integer.parseInt(br.readLine());

            for (int noteNum = 1; noteNum <= noteCnt; noteNum++) {
                if (prefixSum[noteNum] > time) {
                    sb.append(noteNum).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
