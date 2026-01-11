import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int year = Integer.parseInt(br.readLine());
        int front = year / 100;
        int back = year % 100;

        int specialYear = -1;
        for (int i = year + 1; i < 10000; i++) {
            if (isSpecialYear(i)) {
                specialYear = i;
                break;
            }
        }

        sb.append(specialYear);

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isSpecialYear(int year) {
        int front = year / 100;
        int back = year % 100;

        int sum = front + back;
        return sum * sum == year;
    }
}
