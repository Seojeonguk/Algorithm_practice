import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n * 5; i++) {
            for (int j = 0; j < n * 5; j++) {
                int tempI = i / n;
                int tempJ = j / n;

                if (tempJ == 0) {
                    sb.append("@");
                } else if (Math.abs(tempI - 2) == 2) {
                    sb.append(tempJ == 4 ? "@" : " ");
                } else if (Math.abs(tempI - 2) == 1) {
                    sb.append(tempJ == 3 ? "@" : " ");
                    if (tempJ == 4) break;
                } else {
                    sb.append(tempJ < 3 ? "@" : " ");
                    if (tempJ == 3) break;
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
