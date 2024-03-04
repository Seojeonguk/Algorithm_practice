import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int year = Integer.parseInt(br.readLine());
        while (true) {
            year++;
            if (isUniqueNumberYear(year)) {
                break;
            }
        }

        sb.append(year);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isUniqueNumberYear(int year) {
        int bit = 0;
        while (year > 0) {
            int lastNum = year % 10;
            if ((bit & (1 << lastNum)) > 0) {
                return false;
            }
            bit |= (1 << lastNum);
            year /= 10;
        }
        return true;
    }
}
