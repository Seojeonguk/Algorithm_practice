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
            int guestCnt = Integer.parseInt(st.nextToken());
            if (guestCnt == 0) {
                break;
            }

            int[] guests = new int[guestCnt];
            int totalGuest = 0;
            for (int i = 0; i < guestCnt; i++) {
                guests[i] = Integer.parseInt(st.nextToken());
                totalGuest += guests[i];
            }

            int samGuest = 0, idxAtSameGuest = -1;
            for (int i = 0; i < guestCnt; i++) {
                samGuest += guests[i];
                if (totalGuest - samGuest == samGuest) {
                    idxAtSameGuest = i;
                    break;
                }
            }

            if (idxAtSameGuest == -1) {
                sb.append("No equal partitioning.\n");
            } else {
                sb.append(String.format("Sam stops at position %d and Ella stops at position %d.\n", idxAtSameGuest + 1, idxAtSameGuest + 2));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
