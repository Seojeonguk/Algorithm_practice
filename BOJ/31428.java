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

        int friendCnt = Integer.parseInt(br.readLine());
        StringTokenizer applyTrackInfo = new StringTokenizer(br.readLine());
        char helloBitTrack = br.readLine().charAt(0);

        int sameTrackFriends = 0;
        for (int friendNum = 1; friendNum <= friendCnt; friendNum++) {
            char track = applyTrackInfo.nextToken().charAt(0);
            if (helloBitTrack == track) {
                sameTrackFriends++;
            }
        }

        sb.append(sameTrackFriends);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
