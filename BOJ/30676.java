import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int waveLength = Integer.parseInt(br.readLine());

        if (waveLength >= 620) {
            sb.append("Red");
        } else if (waveLength >= 590) {
            sb.append("Orange");
        } else if (waveLength >= 570) {
            sb.append("Yellow");
        } else if (waveLength >= 495) {
            sb.append("Green");
        } else if (waveLength >= 450) {
            sb.append("Blue");
        } else if (waveLength >= 425) {
            sb.append("Indigo");
        } else if (waveLength >= 380) {
            sb.append("Violet");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
