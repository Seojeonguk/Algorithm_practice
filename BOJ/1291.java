import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int STARCRAFT_NUM = 2;
    static final int CHICKEN_NUM = 4;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean isPerfectNum = checkPerfectNum(n);
        boolean isSpecialNum = checkSpecialNum(n);

        if (isPerfectNum && isSpecialNum) {
            sb.append(4);
        } else if (isPerfectNum) {
            sb.append(1);
        } else if (isSpecialNum) {
            sb.append(2);
        } else {
            sb.append(3);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkPerfectNum(int n) {
        if (n <= 5) {
            return false;
        }
        int digitSum = 0;
        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }

        if (digitSum % 2 == 0) {
            return false;
        }

        return true;
    }

    public static boolean checkSpecialNum(int n) {
        if (n == STARCRAFT_NUM || n == CHICKEN_NUM) {
            return true;
        }

        if (n == 1) {
            return false;
        }

        int primeCnt = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                primeCnt++;
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        return (primeCnt % 2 == 0);
    }
}
