import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int floors = Integer.parseInt(st.nextToken());
        int housesOnFloor = Integer.parseInt(st.nextToken());
        int fine = Integer.parseInt(st.nextToken());

        int[] cats = new int[floors * housesOnFloor];
        st = new StringTokenizer(br.readLine());
        for (int house = 0; house < floors * housesOnFloor; house++) {
            cats[house] = Integer.parseInt(st.nextToken());
        }

        int totalFine = 0;
        for (int floor = 0; floor < floors - 1; floor++) {
            for (int houseOnFloor = 0; houseOnFloor < housesOnFloor; houseOnFloor++) {
                int downHouseCat = cats[floor * housesOnFloor + houseOnFloor];
                int upHouseCat = cats[(floor + 1) * housesOnFloor + houseOnFloor];

                if (downHouseCat * 2 < upHouseCat) {
                    totalFine += fine;
                }
            }
        }

        sb.append(totalFine);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
