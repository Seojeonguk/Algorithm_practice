import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int roomCnt = Integer.parseInt(br.readLine());

            StringTokenizer smallRoomInfo = new StringTokenizer(br.readLine());
            long[] smallRooms = new long[roomCnt];
            for (int idx = 0; idx < roomCnt; idx++) {
                smallRooms[idx] = Long.parseLong(smallRoomInfo.nextToken());
            }

            sb.append(calMaxAnts(smallRooms));

            bw.write(sb.toString());
        }
    }

    public static long calMaxAnts(long[] smallRooms) {
        long sum = Arrays.stream(smallRooms).sum();
        if (sum == 0) {
            return smallRooms.length / 2;
        }

        long[] newSmallRooms = new long[smallRooms.length];
        for (int idx = 0; idx < smallRooms.length; idx++) {
            if (smallRooms[idx] > 0) {
                int range = smallRooms.length - idx - 1;
                System.arraycopy(smallRooms, idx + 1, newSmallRooms, 0, range);
                System.arraycopy(smallRooms, 0, newSmallRooms, range, idx + 1);
                break;
            }
        }

        boolean[] hasSmallRooms = new boolean[smallRooms.length];
        for (int idx = 0; idx < newSmallRooms.length; idx++) {
            if (newSmallRooms[idx] > 0) {
                hasSmallRooms[idx] = true;
            }
        }

        boolean[] selected = new boolean[smallRooms.length];
        for (int idx = 0; idx < newSmallRooms.length; idx++) {
            if (isSelect(selected, hasSmallRooms, idx)) {
                selected[idx] = true;
                sum++;
            }
        }

        return sum;
    }

    public static boolean isSelect(boolean[] selectedRooms, boolean[] hasSmallRooms, int idx) {
        if (hasSmallRooms[idx]) {
            return false;
        }

        int mod = selectedRooms.length;
        return !selectedRooms[calIdx(idx - 1, mod)] && !selectedRooms[idx] && !selectedRooms[calIdx(idx + 1, mod)];
    }

    public static int calIdx(int idx, int mod) {
        return (idx + mod) % mod;
    }
}
