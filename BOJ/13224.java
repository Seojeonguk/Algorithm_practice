import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] magicianMoves = br.readLine().toCharArray();

            int currentUnderCup = 1;
            for (char move : magicianMoves) {
                if (move == 'A') {
                    if (currentUnderCup == 1) {
                        currentUnderCup = 2;
                    } else if (currentUnderCup == 2) {
                        currentUnderCup = 1;
                    }
                } else if (move == 'B') {
                    if (currentUnderCup == 2) {
                        currentUnderCup = 3;
                    } else if (currentUnderCup == 3) {
                        currentUnderCup = 2;
                    }
                } else if (move == 'C') {
                    if (currentUnderCup == 1) {
                        currentUnderCup = 3;
                    } else if (currentUnderCup == 3) {
                        currentUnderCup = 1;
                    }
                }
            }

            sb.append(currentUnderCup);

            bw.write(sb.toString());
        }
    }
}
