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

        int animalCnt = Integer.parseInt(br.readLine());
        int fastestFromTime = 0, fastestToTime = Integer.MAX_VALUE;
        for (int animalNum = 0; animalNum < animalCnt; animalNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromHour = Integer.parseInt(st.nextToken());
            int fromMinute = Integer.parseInt(st.nextToken());

            int toHour = Integer.parseInt(st.nextToken());
            int toMinute = Integer.parseInt(st.nextToken());

            int fromTime = fromHour * 60 + fromMinute;
            int toTime = toHour * 60 + toMinute;

            fastestFromTime = Math.max(fromTime, fastestFromTime);
            fastestToTime = Math.min(toTime, fastestToTime);
        }

        if (fastestFromTime < fastestToTime) {
            sb.append("TAIP\n");
            sb.append(String.format("%d %d %d %d\n", fastestFromTime / 60, fastestFromTime % 60, fastestToTime / 60, fastestToTime % 60));
        } else {
            sb.append("NE");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
