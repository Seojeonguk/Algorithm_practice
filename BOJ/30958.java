import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int logoSongLength = Integer.parseInt(br.readLine());
        char[] logoSong = br.readLine().toCharArray();

        int[] appearedCounts = new int[26];
        for (int i = 0; i < logoSongLength; i++) {
            if (Character.isAlphabetic(logoSong[i])) {
                appearedCounts[logoSong[i] - 'a']++;
            }
        }

        int maxAppearedCount = Arrays.stream(appearedCounts).max().getAsInt();
        sb.append(maxAppearedCount);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
