import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int personCnt = Integer.parseInt(br.readLine());

        for (int threeRoom = personCnt / 3; threeRoom >= 0; threeRoom--) {
            int twoRoomPerson = personCnt - threeRoom * 3;
            if (twoRoomPerson % 2 == 0) {
                sb.append(twoRoomPerson / 2).append(" ").append(threeRoom);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
