import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lunchCost = Integer.parseInt(br.readLine());
        int billCnt = Integer.parseInt(br.readLine());
        int[] bills = new int[billCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < billCnt; i++) {
            bills[i] = Integer.parseInt(st.nextToken());
        }

        boolean EdwardPay = canEdwardPay(lunchCost, bills);
        sb.append(EdwardPay ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canEdwardPay(int lunchCost, int[] bills) {
        int sum = Arrays.stream(bills).sum();
        for (int i = 0; i < bills.length; i++) {
            if (sum - bills[i] > lunchCost) {
                return true;
            }
        }
        return false;
    }
}
