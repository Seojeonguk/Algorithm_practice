import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Map<Character, String> clubs = Map.of(
            'M', "MatKor",
            'W', "WiCys",
            'C', "CyKor",
            'A', "AlKor",
            '$', "$clear"
    );

    public static void main(String[] args) throws Exception {
        char clubOfFirstText = br.readLine().charAt(0);

        sb.append(clubs.get(clubOfFirstText));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
