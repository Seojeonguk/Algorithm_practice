import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int deliveredPackageCnt, collisionCnt;
    static int DELIVERED_PACKAGE_POINT = 50;
    static int COLLISION_POINT = -10;

    public static void main(String[] args) throws Exception {
        deliveredPackageCnt = Integer.parseInt(br.readLine());
        collisionCnt = Integer.parseInt(br.readLine());

        int finalScore = deliveredPackageCnt * DELIVERED_PACKAGE_POINT + collisionCnt * COLLISION_POINT;
        if (deliveredPackageCnt > collisionCnt) {
            finalScore += 500;
        }

        sb.append(finalScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
