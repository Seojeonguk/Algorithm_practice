import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String firstSquad = br.readLine();
        String secondSquad = br.readLine();
        String resultSquad = "";

        for (int idx = 0; idx < firstSquad.length(); idx++) {
            char firstClone = firstSquad.charAt(idx);
            char secondClone = secondSquad.charAt(idx);
            resultSquad += (firstClone > secondClone ? firstClone : secondClone);
        }
        sb.append(resultSquad);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
