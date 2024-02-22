import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer inputs = new StringTokenizer(br.readLine());
            int happenedDrawCnt = Integer.parseInt(inputs.nextToken());
            int betCompriseCnt = Integer.parseInt(inputs.nextToken());
            int betMaxNum = Integer.parseInt(inputs.nextToken());

            if (happenedDrawCnt == 0 && betCompriseCnt == 0 && betMaxNum == 0) {
                break;
            }

            int[] drawsCnt = new int[betMaxNum + 1];
            for (int i = 0; i < happenedDrawCnt; i++) {
                StringTokenizer drawInfo = new StringTokenizer(br.readLine());
                for (int j = 0; j < betCompriseCnt; j++) {
                    int drawNum = Integer.parseInt(drawInfo.nextToken());
                    drawsCnt[drawNum]++;
                }
            }

            ArrayList<Integer> minDrawNums = new ArrayList<>();
            int minDrawCnt = Integer.MAX_VALUE;
            for (int drawNum = 1; drawNum <= betMaxNum; drawNum++) {
                if (minDrawCnt > drawsCnt[drawNum]) {
                    minDrawNums.clear();
                    minDrawCnt = drawsCnt[drawNum];
                    minDrawNums.add(drawNum);
                } else if (minDrawCnt == drawsCnt[drawNum]) {
                    minDrawNums.add(drawNum);
                }
            }

            Iterator<Integer> it = minDrawNums.iterator();
            while (it.hasNext()) {
                sb.append(it.next()).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
