import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int visitedRoomCnt = Integer.parseInt(st.nextToken());
        int buildingHeight = Integer.parseInt(st.nextToken());
        int roomPerFloorCnt = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] wantedRooms = new ArrayList[buildingHeight + 1];
        for (int i = 0; i <= buildingHeight; i++) {
            wantedRooms[i] = new ArrayList<>();
        }

        while (visitedRoomCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int room = Integer.parseInt(st.nextToken());
            wantedRooms[height].add(room);
        }

        for (int i = 0; i <= buildingHeight; i++) {
            Collections.sort(wantedRooms[i]);
        }

        int leftRoom = 1, leftTime = 0;
        int rightRoom = 1, rightTime = 0;
        if (!wantedRooms[1].isEmpty()) {
            leftRoom = wantedRooms[1].get(wantedRooms[1].size() - 1);
            leftTime = leftRoom - 1;
            rightRoom = wantedRooms[1].get(wantedRooms[1].size() - 1);
            rightTime = rightRoom - 1;
        }
        int prevHeight = 1;

        for (int height = 2; height <= buildingHeight; height++) {
            if (wantedRooms[height].isEmpty()) {
                continue;
            }
            int nextLeftRoom = wantedRooms[height].get(0);
            int nextRightRoom = wantedRooms[height].get(wantedRooms[height].size() - 1);
            int nextLeftTime = Math.min(leftTime + Math.abs(leftRoom - nextRightRoom), rightTime + Math.abs(rightRoom - nextRightRoom)) + (nextRightRoom - nextLeftRoom) + (height - prevHeight) * 100;
            int nextRightTime = Math.min(leftTime + Math.abs(leftRoom - nextLeftRoom), rightTime + Math.abs(rightRoom - nextLeftRoom)) + (nextRightRoom - nextLeftRoom) + (height - prevHeight) * 100;

            leftRoom = nextLeftRoom;
            rightRoom = nextRightRoom;
            leftTime = nextLeftTime;
            rightTime = nextRightTime;
            prevHeight = height;
        }
        sb.append(Math.min(leftTime, rightTime));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
