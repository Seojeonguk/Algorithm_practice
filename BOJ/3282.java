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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hotelRoomCnt = Integer.parseInt(st.nextToken());
        int visitedGroupCnt = Integer.parseInt(st.nextToken());

        int[] hotelRooms = new int[hotelRoomCnt];
        int currentRoom = 0;
        for (int i = 0; i < visitedGroupCnt; i++) {
            int guestCnt = Integer.parseInt(br.readLine());
            while (guestCnt > 0 && currentRoom < hotelRoomCnt) {
                if (hotelRooms[currentRoom] == 2) {
                    currentRoom++;
                    if (currentRoom == hotelRoomCnt) {
                        break;
                    }
                }
                hotelRooms[currentRoom]++;
                guestCnt--;
            }
            currentRoom++;

            while (guestCnt-- > 0) {
                for (int room = 0; room < hotelRoomCnt; room++) {
                    if (hotelRooms[room] < 2) {
                        hotelRooms[room]++;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < hotelRoomCnt; i++) {
            sb.append(hotelRooms[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
