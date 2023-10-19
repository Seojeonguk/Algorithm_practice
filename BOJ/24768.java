import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine());
            int sweetJars = Integer.parseInt(st.nextToken());
            int sourJars = Integer.parseInt(st.nextToken());
            if (sweetJars == 0 && sourJars == 0) {
                break;
            }

            if (sweetJars + sourJars == 13) {
                sb.append("Never speak again.").append("\n");
            } else if (sweetJars > sourJars) {
                sb.append("To the convention.").append("\n");
            } else if (sweetJars < sourJars) {
                sb.append("Left beehind.").append("\n");
            } else {
                sb.append("Undecided.").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
