import java.math.MathContext;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MOD = 10000;

    public static void main(String[] args) throws Exception {
        int personCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < personCnt; i++) {
            String id = br.readLine();

            int idKey = getIDKey(id);

            sb.append(String.format("%04d\n", idKey));
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getIDKey(String id) {
        int sumOfDigit = 0;
        for (int idx = 0; idx < 13; idx++) {
            sumOfDigit += (id.charAt(idx) - '0');
        }

        int resultBy10ForLast3Digits = Integer.parseInt(id.substring(10)) * 10;

        int idKey = sumOfDigit + resultBy10ForLast3Digits;

        if (idKey < 1000) {
            idKey += 1000;
        }

        return idKey % MOD;
    }
}
