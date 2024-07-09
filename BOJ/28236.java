import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int schoolFloor = Integer.parseInt(st.nextToken());
            int classPerFloor = Integer.parseInt(st.nextToken());
            int raceParticipationClassCnt = Integer.parseInt(st.nextToken());

            int prizeClass = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int classNum = 1; classNum <= raceParticipationClassCnt; classNum++) {
                StringTokenizer classInfo = new StringTokenizer(br.readLine());
                int floor = Integer.parseInt(classInfo.nextToken());
                int distanceFromLeft = Integer.parseInt(classInfo.nextToken());

                int distance = floor + classPerFloor - distanceFromLeft;
                if (minDistance > distance) {
                    minDistance = distance;
                    prizeClass = classNum;
                }
            }

            sb.append(prizeClass);

            bw.write(sb.toString());
        }
    }
}
