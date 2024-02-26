import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final String[] DIRECTIONS = {"W", "A", "S", "D", "LU", "LD", "RU", "RD"};
    static final int[] REVERSE_DIRECTION = {2, 3, 0, 1, 7, 6, 5, 4};
    static final Map<Character, Integer> INPUT_KEYS = new HashMap<>() {{
        put('W', 0);
        put('8', 0);
        put('S', 2);
        put('2', 2);
        put('A', 1);
        put('4', 1);
        put('D', 3);
        put('6', 3);
        put('7', 4);
        put('1', 5);
        put('9', 6);
        put('3', 7);
    }};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String note = br.readLine();
        ArrayList<Integer> notes = convertNote(note);

        int matchCnt = 0;
        char[] inputKeys = br.readLine().toCharArray();
        for (int idx = 0; idx < inputKeys.length; idx++) {
            if (matchCnt == notes.size()) {
                matchCnt = 0;
            } else if (notes.get(matchCnt) == INPUT_KEYS.get(inputKeys[idx])) {
                matchCnt++;
            } else {
                matchCnt = 0;
            }
        }

        sb.append(matchCnt == notes.size() ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> convertNote(String note) {
        ArrayList<Integer> notes = new ArrayList<>();

        while (note.length() > 0) {
            for (int i = 0; i < DIRECTIONS.length; i++) {
                if (note.startsWith(DIRECTIONS[i])) {
                    boolean isReverse = false;
                    int directionLength = DIRECTIONS[i].length();
                    if (note.length() != directionLength && note.charAt(directionLength) == '!') {
                        isReverse = true;
                    }

                    notes.add(isReverse ? REVERSE_DIRECTION[i] : i);

                    note = note.substring(directionLength + (isReverse ? 1 : 0));
                    break;
                }
            }
        }

        return notes;
    }
}
