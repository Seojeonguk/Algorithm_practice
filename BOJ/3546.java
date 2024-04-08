import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] chambers = br.readLine().toCharArray();
        int emptyChamberCnt = 0, prevEmptyChamberCnt = 0;
        for (int i = 0; i < chambers.length; i++) {
            if (chambers[i] == '0') {
                emptyChamberCnt++;
                if (chambers[(i + chambers.length - 1) % chambers.length] == '0') {
                    prevEmptyChamberCnt++;
                }
            }
        }

        if (emptyChamberCnt * emptyChamberCnt < chambers.length * prevEmptyChamberCnt) {
            sb.append("SHOOT");
        } else if (emptyChamberCnt * emptyChamberCnt > chambers.length * prevEmptyChamberCnt) {
            sb.append("ROTATE");
        } else {
            sb.append("EQUAL");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
