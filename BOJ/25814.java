import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int firstWeight = getWeight(first);
        int second = Integer.parseInt(st.nextToken());
        int secondWeight = getWeight(second);

        if (firstWeight > secondWeight) {
            sb.append(1);
        } else if (firstWeight < secondWeight) {
            sb.append(2);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getWeight(int x) {
        int weight = String.valueOf(x).length();
        int sumDigits = 0;
        while (x > 0) {
            sumDigits += x % 10;
            x /= 10;
        }
        weight *= sumDigits;
        return weight;
    }
}
