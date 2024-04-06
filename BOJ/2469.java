import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int totalParticipant = Integer.parseInt(br.readLine());
        int rowSize = Integer.parseInt(br.readLine());

        char[] starts = new char[totalParticipant];
        char[] results = br.readLine().toCharArray();

        for (int idx = 0; idx < totalParticipant; idx++) {
            starts[idx] = (char) (idx + 'A');
        }

        char[][] ladders = new char[rowSize][totalParticipant - 1];
        int targetRow = -1;

        for (int row = 0; row < rowSize; row++) {
            ladders[row] = br.readLine().toCharArray();
            if (ladders[row][0] == '?') {
                targetRow = row;
            }
        }

        for (int row = 0; row < targetRow; row++) {
            for (int col = 0; col < totalParticipant - 1; col++) {
                if (ladders[row][col] == '-') {
                    swap(starts, col, col + 1);
                }
            }
        }

        for (int row = rowSize - 1; row > targetRow; row--) {
            for (int col = 0; col < totalParticipant - 1; col++) {
                if (ladders[row][col] == '-') {
                    swap(results, col, col + 1);
                }
            }
        }

        sb.append(findLadder(starts, results));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String findLadder(char[] starts, char[] results) {
        StringBuilder ladder = new StringBuilder();
        for (int i = 0; i < starts.length - 1; i++) {
            if (starts[i] == results[i]) {
                ladder.append("*");
            } else if (starts[i] == results[i + 1] && starts[i + 1] == results[i]) {
                ladder.append("-");
                swap(starts, i, i + 1);
            } else {
                ladder.replace(0, starts.length - 1, "x".repeat(starts.length - 1));
                break;
            }
        }

        return ladder.toString();
    }

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
