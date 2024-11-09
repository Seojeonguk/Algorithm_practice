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

            int stopCnt = Integer.parseInt(br.readLine());

            long maxCapacity = 0;
            long currentCapacity = 0;
            for (int i = 0; i < stopCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int getOff = Integer.parseInt(st.nextToken());
                int getOn = Integer.parseInt(st.nextToken());

                currentCapacity += getOn - getOff;
                maxCapacity = Math.max(maxCapacity, currentCapacity);
            }

            sb.append(maxCapacity);

            bw.write(sb.toString());
        }
    }
}
