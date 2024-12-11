import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int START_ONION_LENGTH = 1;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int testDays = Integer.parseInt(st.nextToken());
            int complimentIncrementLength = Integer.parseInt(st.nextToken());
            int blameIncrementLength = Integer.parseInt(st.nextToken());

            int complimentOnion = START_ONION_LENGTH;
            int blameOnion = START_ONION_LENGTH;

            for (int day = 1; day <= testDays; day++) {
                complimentOnion += complimentIncrementLength;
                blameOnion += blameIncrementLength;

                if (complimentOnion < blameOnion) {
                    int temp = complimentOnion;
                    complimentOnion = blameOnion;
                    blameOnion = temp;
                } else if (complimentOnion == blameOnion) {
                    blameOnion--;
                }
            }

            sb.append(complimentOnion).append(" ").append(blameOnion);

            bw.write(sb.toString());
        }
    }
}
