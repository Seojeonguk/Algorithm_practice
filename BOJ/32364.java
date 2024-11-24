import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int participantCnt = Integer.parseInt(br.readLine());

            int[] hats = new int[participantCnt];
            for (int i = 0; i < participantCnt; i++) {
                hats[i] = Integer.parseInt(br.readLine());
            }

            int sameHat = 0;
            int middle = participantCnt / 2;
            for (int i = 0; i < participantCnt; i++) {
                int opponentHat = hats[(i + middle) % participantCnt];

                if (hats[i] == opponentHat) {
                    sameHat++;
                }
            }

            sb.append(sameHat);

            bw.write(sb.toString());
        }
    }
}
