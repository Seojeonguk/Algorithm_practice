import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            long videoCnt = Long.parseLong(br.readLine());

            if (videoCnt <= 28) {
                for (long firstDay = 1; ; firstDay++) {
                    long video = 0;
                    for (int i = 0; i < 7; i++) {
                        video += Math.max(firstDay - i, 0);
                    }

                    if (video >= videoCnt) {
                        sb.append(firstDay);
                        break;
                    }
                }
            } else {
                long a = (videoCnt - 21) / 7;
                if (a * 7 + 21 < videoCnt) {
                    a++;
                }

                sb.append(a + 6);
            }

            bw.write(sb.toString());
        }
    }
}
