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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int totalTick = Integer.parseInt(st.nextToken());
            int firstCode = Integer.parseInt(st.nextToken());
            int secondCode = Integer.parseInt(st.nextToken());
            int thirdCode = Integer.parseInt(st.nextToken());

            if (totalTick == 0) {
                break;
            }

            int movedTickCnt = totalTick * 3 - 1;
            movedTickCnt += totalTick + (totalTick + secondCode - firstCode) % totalTick;
            movedTickCnt += (totalTick + secondCode - thirdCode) % totalTick;

            sb.append(movedTickCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
