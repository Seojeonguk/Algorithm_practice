import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int CHESS_SIZE = 8;
    final static Map<Character, Integer> PIECE_SCORE = Map.of(
            'k', 0,
            'p', 1,
            'n', 3,
            'b', 3,
            'r', 5,
            'q', 9
    );
    
    public static void main(String[] args) throws Exception {
        int whiteScore = 0, blackScore = 0;
        for (int row = 0; row < CHESS_SIZE; row++) {
            String chessInfo = br.readLine();
            for (int col = 0; col < CHESS_SIZE; col++) {
                char piece = chessInfo.charAt(col);
                if (!Character.isAlphabetic(piece)) {
                    continue;
                }
                int score = PIECE_SCORE.get(Character.toLowerCase(piece));
                if (Character.isLowerCase(piece)) {
                    blackScore += score;
                } else {
                    whiteScore += score;
                }
            }
        }
        sb.append(whiteScore - blackScore);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
