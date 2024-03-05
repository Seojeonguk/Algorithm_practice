import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] n = br.readLine().toCharArray();

        boolean isChampernowneWord = true;
        for (int idx = 0; idx < n.length; idx++) {
            if (n[idx] - '1' != idx) {
                isChampernowneWord = false;
                break;
            }
        }

        sb.append(isChampernowneWord ? n.length : -1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
