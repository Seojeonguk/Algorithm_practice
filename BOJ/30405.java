import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer museumInfo = new StringTokenizer(br.readLine());
        int babyCatCnt = Integer.parseInt(museumInfo.nextToken());
        int museumCnt = Integer.parseInt(museumInfo.nextToken());

        ArrayList<Integer> entrances = new ArrayList<>();

        for (int babyCatNum = 0; babyCatNum < babyCatCnt; babyCatNum++) {
            StringTokenizer babyCatAttendanceOrderInfo = new StringTokenizer(br.readLine());
            int babyCatAttendanceCnt = Integer.parseInt(babyCatAttendanceOrderInfo.nextToken());

            for (int babyCatAttendanceNum = 0; babyCatAttendanceNum < babyCatAttendanceCnt; babyCatAttendanceNum++) {
                int babyCatAttendanceMuseumNum = Integer.parseInt(babyCatAttendanceOrderInfo.nextToken());
                if (babyCatAttendanceNum == 0 || babyCatAttendanceNum == babyCatAttendanceCnt - 1) {
                    entrances.add(babyCatAttendanceMuseumNum);
                }
            }
        }

        Collections.sort(entrances);
        sb.append(entrances.get(babyCatCnt - 1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
