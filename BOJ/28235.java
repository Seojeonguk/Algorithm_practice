import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String slogan;

    public static void main(String[] args) throws Exception {
        Map<String, String> cheers = Map.of(
                "SONGDO", "HIGHSCHOOL",
                "CODE", "MASTER",
                "2023", "0611",
                "ALGORITHM", "CONTEST"
        );

        slogan = br.readLine();

        sb.append(cheers.get(slogan));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
