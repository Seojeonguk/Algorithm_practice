import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int shootScore = Integer.parseInt(br.readLine());
            int isScore = Integer.parseInt(br.readLine());
            int isFoul = Integer.parseInt(br.readLine());

            int score = (isScore == 1 ? shootScore : 0);
            if (isFoul == 1) {
                int addedChance = (isScore == 1 ? 1 : shootScore);

                for (int i = 0; i < addedChance; i++) {
                    int isAddedScore = Integer.parseInt(br.readLine());
                    if (isAddedScore == 1) {
                        score++;
                    }
                }
            }

            sb.append(score);

            bw.write(sb.toString());
        }
    }
}
