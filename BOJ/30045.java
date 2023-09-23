import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int promotionalPostCnt = Integer.parseInt(br.readLine());
        int putEmoticonCnt = 0;
        while (promotionalPostCnt-- > 0) {
            String promotionalPost = br.readLine();
            if (promotionalPost.contains("01") || promotionalPost.contains("OI")) {
                putEmoticonCnt++;
            }
        }
        sb.append(putEmoticonCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
