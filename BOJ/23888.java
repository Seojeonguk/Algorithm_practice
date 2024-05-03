import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String[] arithmeticProgression = br.readLine().split(" ");
            int firstTerm = Integer.parseInt(arithmeticProgression[0]);
            int commonDifference = Integer.parseInt(arithmeticProgression[1]);

            int queryCnt = Integer.parseInt(br.readLine());
            for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
                String[] query = br.readLine().split(" ");
                int command = Integer.parseInt(query[0]);
                int l = Integer.parseInt(query[1]);
                int r = Integer.parseInt(query[2]);

                if (command == 1) {
                    sb.append(calRangeSum(firstTerm, commonDifference, l, r)).append("\n");
                } else {
                    sb.append(calRangeGcd(firstTerm, commonDifference, l, r)).append("\n");
                }
            }
            bw.write(sb.toString());
        }
    }

    public static long calRangeSum(int firstTerm, int commonDifference, int l, int r) {
        long sum = (long) (r - l + 1) * firstTerm;
        sum += (((long) r * (r - 1)) / 2 - ((long) (l - 1) * (l - 2)) / 2) * commonDifference;

        return sum;
    }

    public static long calRangeGcd(int firstTerm, int commonDifference, int l, int r) {
        if (commonDifference == 0) {
            return firstTerm;
        }

        long gcd = firstTerm + (long) (l - 1) * commonDifference;
        long prevGcd = gcd;
        for (int i = 0; i < r - l; i++) {
            gcd = calGcd(gcd, commonDifference);
            if (gcd == 1 || prevGcd == gcd) {
                break;
            }
            prevGcd = gcd;
        }

        return gcd;
    }

    public static long calGcd(long x, long y) {
        if (y == 0) {
            return x;
        }

        return calGcd(y, x % y);
    }
}
