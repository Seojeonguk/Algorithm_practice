import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static Map<String, String> SEMINARS = Map.of(
            "Algorithm", "204",
            "DataAnalysis", "207",
            "ArtificialIntelligence", "302",
            "CyberSecurity", "B101",
            "Network", "303",
            "Startup", "501",
            "TestStrategy", "105"

    );

    public static void main(String[] args) throws Exception {
        int seminarCnt = Integer.parseInt(br.readLine());

        while (seminarCnt-- > 0) {
            String seminar = br.readLine();
            sb.append(SEMINARS.get(seminar)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
