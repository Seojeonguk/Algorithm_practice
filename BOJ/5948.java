import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> appearedNum = new HashSet<>();
        int repeatCnt = 0;
        while (!appearedNum.contains(n)) {
            appearedNum.add(n);
            int middle = (n / 100) % 10 * 10 + (n / 10) % 10;
            int square = middle * middle;
            n = square;
            repeatCnt++;
        }

        sb.append(repeatCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
