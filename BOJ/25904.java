import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int sound = Integer.parseInt(st.nextToken());

        int[] maxSounds = new int[people];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < people; idx++) {
            maxSounds[idx] = Integer.parseInt(st.nextToken());
        }

        int peopleNum = 0;
        while (true) {
            if (sound > maxSounds[peopleNum]) {
                break;
            }
            peopleNum = (peopleNum + 1) % people;
            sound++;
        }
        sb.append(peopleNum + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
