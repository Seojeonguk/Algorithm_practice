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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cardCnt = Integer.parseInt(st.nextToken());
            int health = Integer.parseInt(st.nextToken());

            StringTokenizer attacks = new StringTokenizer(br.readLine());
            int sumAttack = 0;
            for (int i = 0; i < cardCnt; i++) {
                int attack = Integer.parseInt(attacks.nextToken());
                sumAttack += attack;

                if (sumAttack >= health) {
                    sb.append(i + 1);
                    break;
                }
            }

            if (sb.isEmpty()) {
                sb.append(-1);
            }

            bw.write(sb.toString());
        }
    }
}
