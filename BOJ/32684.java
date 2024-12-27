import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int CAR_SCORE = 130;
    static final int CANNON_SCORE = 70;
    static final int HORSE_SCORE = 50;
    static final int ELEPHANT_SCORE = 30;
    static final int GUARD_SCORE = 30;
    static final int PAWN_SCORE = 20;
    static final int EXTRA_SCORE = 15;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer cheokPieces = new StringTokenizer(br.readLine());
            Piece cheok = new Piece(cheokPieces, false);

            StringTokenizer eunPieces = new StringTokenizer(br.readLine());
            Piece eun = new Piece(eunPieces, true);

            if (cheok.calScore() > eun.calScore()) {
                sb.append("cocjr0208");
            } else {
                sb.append("ekwoo");
            }

            bw.write(sb.toString());
        }
    }

    static class Piece {
        int car;
        int cannon;
        int horse;
        int elephant;
        int guard;
        int pawn;
        boolean isSecondPlayer;

        Piece(StringTokenizer st, boolean isSecondPlayer) {
            car = Integer.parseInt(st.nextToken());
            cannon = Integer.parseInt(st.nextToken());
            horse = Integer.parseInt(st.nextToken());
            elephant = Integer.parseInt(st.nextToken());
            guard = Integer.parseInt(st.nextToken());
            pawn = Integer.parseInt(st.nextToken());
            this.isSecondPlayer = isSecondPlayer;
        }

        public int calScore() {
            int score = 0;

            score = car * CAR_SCORE
                    + cannon * CANNON_SCORE
                    + horse * HORSE_SCORE
                    + elephant * ELEPHANT_SCORE
                    + guard * GUARD_SCORE
                    + pawn * PAWN_SCORE;

            if (isSecondPlayer) {
                score += EXTRA_SCORE;
            }

            return score;
        }
    }
}
