import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int ROOM_COUNT = 10;

    public static void main(String[] args) throws Exception {
        int totalEvent = Integer.parseInt(br.readLine());
        char[] events = br.readLine().toCharArray();

        boolean[] rooms = new boolean[ROOM_COUNT];
        for (int i = 0; i < events.length; i++) {
            if (events[i] == 'L') {
                for (int idx = 0; idx < ROOM_COUNT; idx++) {
                    if (!rooms[idx]) {
                        rooms[idx] = true;
                        break;
                    }
                }
            } else if (events[i] == 'R') {
                for (int idx = ROOM_COUNT - 1; idx >= 0; idx--) {
                    if (!rooms[idx]) {
                        rooms[idx] = true;
                        break;
                    }
                }
            } else {
                int leaveRoom = events[i] - '0';
                rooms[leaveRoom] = false;
            }
        }

        for (int roomNum = 0; roomNum < ROOM_COUNT; roomNum++) {
            sb.append(rooms[roomNum] ? 1 : 0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
