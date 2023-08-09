import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int p, q;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> pFactors = calFactor(p);
        ArrayList<Integer> qFactors = calFactor(q);

        for (int pFactor : pFactors) {
            for (int qFactor : qFactors) {
                sb.append(pFactor).append(" ").append(qFactor).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> calFactor(int x) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i != 0) {
                continue;
            }
            factors.add(i);
            if (i * i != x) {
                factors.add(x / i);
            }
        }
        Collections.sort(factors);

        return factors;
    }
}
