import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int clubFloor = Integer.parseInt(br.readLine());
        String mascot = br.readLine();
        int curMascotFloor = Integer.parseInt(br.readLine());

        if ("annyong".equals(mascot)) {
            sb.append(curMascotFloor % 2 == 1 ? curMascotFloor : curMascotFloor - 1);
        } else {
            if (curMascotFloor % 2 == 0) {
                sb.append(curMascotFloor);
            } else {
                sb.append(curMascotFloor != 1 ? curMascotFloor - 1 : curMascotFloor + 1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
