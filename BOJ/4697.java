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
            int apartmentCnt = Integer.parseInt(st.nextToken());
            int roomWidth = Integer.parseInt(st.nextToken());
            int roomLength = Integer.parseInt(st.nextToken());
            int roomHeight = Integer.parseInt(st.nextToken());
            int area = Integer.parseInt(st.nextToken());
            int windowAndDoorCnt = Integer.parseInt(st.nextToken());

            if (apartmentCnt == 0) {
                break;
            }

            int windowAndDoorArea = 0;
            for (int i = 0; i < windowAndDoorCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int windowAndDoorWidth = Integer.parseInt(st.nextToken());
                int windowAndDoorsHeight = Integer.parseInt(st.nextToken());

                windowAndDoorArea += windowAndDoorWidth * windowAndDoorsHeight;
            }

            int totalArea = apartmentCnt * (roomWidth * roomLength + 2 * roomHeight * (roomWidth + roomLength) - windowAndDoorArea);
            sb.append((totalArea + area - 1) / area).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
