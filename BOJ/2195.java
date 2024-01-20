import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        String p = br.readLine();

        int curIdx = 0;
        int sSize = s.length();
        int pSize = p.length();

        int copyCnt = 0;
        while (curIdx < pSize) {
            int size = 1;
            while (curIdx + size <= pSize) {
                String subP = p.substring(curIdx, curIdx + size);
                if (!s.contains(subP)) {
                    break;
                }
                size++;
            }
            copyCnt++;
            curIdx = curIdx + size - 1;
        }

        sb.append(copyCnt).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
