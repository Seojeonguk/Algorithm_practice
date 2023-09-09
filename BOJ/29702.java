import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            long currentRoom = Long.parseLong(br.readLine());

            int height = -1;
            long roomNumber = -1;
            for (int i = 62; i >= 0; i--) {
                long v = (1L << i);
                if ((v & currentRoom) != 0) {
                    height = i + 1;
                    roomNumber = currentRoom - v + 1;
                    break;
                }
            }
            while (height > 0) {
                int roomNumberLength = String.valueOf(roomNumber).length();

                sb.append(height);
                for (int i = 0; i < 18 - roomNumberLength; i++) {
                    sb.append("0");
                }
                sb.append(roomNumber);
                height--;
                roomNumber = (roomNumber + 1) / 2;
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
