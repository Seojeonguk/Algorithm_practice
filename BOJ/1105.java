import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] l = st.nextToken().toCharArray();
        char[] r = st.nextToken().toCharArray();

        int minEightCnt = calMinEightCnt(l, r);
        sb.append(minEightCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMinEightCnt(char[] l, char[] r) {
        if (l.length != r.length) {
            return 0;
        }

        int sameIdx = 0;
        int appearedEightCnt = 0;
        while (sameIdx < l.length) {
            if (l[sameIdx] != r[sameIdx]) {
                break;
            }
            if (l[sameIdx] == '8') {
                appearedEightCnt++;
            }
            sameIdx++;
        }

        return appearedEightCnt;
    }
}
