import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int checkDays = Integer.parseInt(br.readLine());
            int[] isRainingDays = new int[checkDays];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int day = 0; day < checkDays; day++) {
                isRainingDays[day] = Integer.parseInt(st.nextToken());
            }

            sb.append(calSumAnger(isRainingDays));

            bw.write(sb.toString());
        }
    }

    public static long calSumAnger(int[] isRainingDays) {
        long sumAnger = 0;
        int currentAnger = 0;

        for (int isRainingDay : isRainingDays) {
            if (isRainingDay == 1) {
                currentAnger++;
            } else {
                currentAnger--;
            }

            sumAnger += currentAnger;
        }

        return sumAnger;
    }
}
