import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int bookCnt = Integer.parseInt(st.nextToken());
        int maxBoxWeight = Integer.parseInt(st.nextToken());

        int boxCnt = 0;
        int nowBoxWeight = maxBoxWeight;
        if (bookCnt != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bookCnt; i++) {
                int weight = Integer.parseInt(st.nextToken());
                if (nowBoxWeight + weight > maxBoxWeight) {
                    nowBoxWeight = weight;
                    boxCnt++;
                } else {
                    nowBoxWeight += weight;
                }
            }
        }
        sb.append(boxCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
