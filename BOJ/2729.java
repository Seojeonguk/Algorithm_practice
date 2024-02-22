import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            String[] binaries = br.readLine().split(" ");

            String res = binariesSum(binaries[0].toCharArray(), binaries[1].toCharArray());

            sb.append(res).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String binariesSum(char[] a, char[] b) {
        int maxLength = Math.max(a.length, b.length);
        char[] res = new char[maxLength + 1];

        int carry = 0;
        int aIdx = a.length - 1, bIdx = b.length - 1, resIdx = res.length - 1;

        while (resIdx >= 0) {
            int curA = (aIdx >= 0 ? a[aIdx--] - '0' : 0);
            int curB = (bIdx >= 0 ? b[bIdx--] - '0' : 0);

            int bitSum = curA + curB + carry;
            res[resIdx--] = (char) ('0' + (curA + curB + carry) % 2);
            carry = (bitSum >= 2 ? 1 : 0);
        }

        String resStr = String.valueOf(res);
        int firstAppearedOneIdx = resStr.indexOf('1');

        return (firstAppearedOneIdx == -1 ? "0" : resStr.substring(firstAppearedOneIdx));
    }
}
