import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int doorCnt = Integer.parseInt(br.readLine());

        int oddCnt = 0, evenCnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int door = 0; door < doorCnt; door++) {
            int numberOnDoor = Integer.parseInt(st.nextToken());
            if (numberOnDoor % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }
        sb.append(evenCnt > oddCnt ? "Happy" : "Sad");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
