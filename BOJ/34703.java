import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int lectureCnt = Integer.parseInt(br.readLine());

        boolean[] isLectureDays = new boolean[6];
        for (int i = 0; i < lectureCnt; i++) {
            int day = Integer.parseInt(br.readLine());
            isLectureDays[day] = true;
        }

        boolean isSuccessRestDay = false;
        for (int day = 1; day <= 5; day++) {
            if (!isLectureDays[day]) {
                isSuccessRestDay = true;
            }
        }

        sb.append(isSuccessRestDay ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
    }
}
