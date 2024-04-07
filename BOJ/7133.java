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

        StringTokenizer cowInfo = new StringTokenizer(br.readLine());
        int cowFirstHappiness = Integer.parseInt(cowInfo.nextToken());
        int cowDecreasingHappiness = Integer.parseInt(cowInfo.nextToken());

        StringTokenizer beeInfo = new StringTokenizer(br.readLine());
        int beeFirstHappiness = Integer.parseInt(beeInfo.nextToken());
        int beeDecreasingHappiness = Integer.parseInt(beeInfo.nextToken());

        int maxHappiness = 0;

        int fieldCnt = Integer.parseInt(br.readLine());
        for (int fieldNum = 0; fieldNum < fieldCnt; fieldNum++) {
            StringTokenizer supportedInfo = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(supportedInfo.nextToken());
            int bee = Integer.parseInt(supportedInfo.nextToken());

            int cowHappiness = calHappiness(cowFirstHappiness, cowDecreasingHappiness, cow);
            int beeHappiness = calHappiness(beeFirstHappiness, beeDecreasingHappiness, bee);

            maxHappiness += Math.max(cowHappiness, beeHappiness);
        }

        sb.append(maxHappiness);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calHappiness(int first, int decreasing, int cnt) {
        int happiness = 0;
        for (int i = 0; i < cnt; i++) {
            int currentHappiness = first - decreasing * i;
            if (currentHappiness < 0) {
                break;
            }
            happiness += currentHappiness;
        }

        return happiness;
    }
}
