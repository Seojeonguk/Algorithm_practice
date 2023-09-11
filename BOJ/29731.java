import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static String[] PLEDGES = {
            "Never gonna give you up",
            "Never gonna let you down",
            "Never gonna run around and desert you",
            "Never gonna make you cry",
            "Never gonna say goodbye",
            "Never gonna tell a lie and hurt you",
            "Never gonna stop"
    };

    public static void main(String[] args) throws Exception {
        int pledgeCnt = Integer.parseInt(br.readLine());

        boolean isAllPledge = true;
        for (int i = 0; i < pledgeCnt; i++) {
            String pledge = br.readLine();
            boolean isPledge = false;
            for (int j = 0; j < PLEDGES.length; j++) {
                if (PLEDGES[j].equals(pledge)) {
                    isPledge = true;
                    break;
                }
            }
            if (!isPledge) {
                isAllPledge = false;
                break;
            }
        }

        sb.append(isAllPledge ? "No" : "Yes");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
