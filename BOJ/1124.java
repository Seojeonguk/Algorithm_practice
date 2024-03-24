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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] primesCnt = new int[b + 1];
        for (int i = 2; i <= b; i++) {
            if (primesCnt[i] > 0) {
                continue;
            }
            for (int j = i; j <= b; j += i) {
                int x = j;
                while (x % i == 0) {
                    primesCnt[j]++;
                    x /= i;
                }
            }
        }

        int underPrimeCnt = 0;
        for (int i = a; i <= b; i++) {
            if (primesCnt[primesCnt[i]] == 1) {
                underPrimeCnt++;
            }
        }

        sb.append(underPrimeCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
