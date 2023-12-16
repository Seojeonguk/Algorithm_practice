import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int considerationPerson = Integer.parseInt(br.readLine());

            char[] noticeHurricane = br.readLine().toCharArray();
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < noticeHurricane.length; i++) {
                hs.add(noticeHurricane[i]);
            }

            int receivedPerson = 0;
            for (int i = 0; i < considerationPerson; i++) {
                char[] consumedMedia = br.readLine().toCharArray();
                if (canReceiveHurricaneWarning(hs, consumedMedia)) {
                    receivedPerson++;
                }
            }

            sb.append("Data Set ").append(tc).append(":\n").append(receivedPerson).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canReceiveHurricaneWarning(HashSet<Character> hs, char[] consumedMedia) {
        for (int i = 0; i < consumedMedia.length; i++) {
            if (hs.contains(consumedMedia[i])) {
                return true;
            }
        }
        return false;
    }
}
