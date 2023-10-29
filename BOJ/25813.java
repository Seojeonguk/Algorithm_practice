import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();

        int leftMostU = str.indexOf('U');
        int rightMostF = str.lastIndexOf('F');

        for (int idx = 0; idx < str.length(); idx++) {
            if (idx < leftMostU || idx > rightMostF) {
                sb.append("-");
            } else if (idx == leftMostU || idx == rightMostF) {
                sb.append(str.charAt(idx));
            } else {
                sb.append("C");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
