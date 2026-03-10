import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int beforeTime = convertSecond(br.readLine());
        int afterTime = convertSecond(br.readLine());

        int hourCnt = 0;
        int minuteCnt = 0;
        int secondCnt = 0;

        for (int i = beforeTime + 1; i <= afterTime; i++) {
            if (i % 60 == 0) {
                secondCnt++;
            }

            if (i % (60 * 60) == 0) {
                minuteCnt++;
            }

            if (i % (12 * 60 * 60) == 0) {
                hourCnt++;
            }
        }

        sb.append(hourCnt).append(" ").append(minuteCnt).append(" ").append(secondCnt);

        bw.write(sb.toString());
        bw.flush();
    }

    public static int convertSecond(String time) {
        String[] str = time.split(":");
        int hour = Integer.parseInt(str[0]);
        int minute = Integer.parseInt(str[1]);
        int second = Integer.parseInt(str[2]);

        return hour * 3600 + minute * 60 + second;
    }
}
