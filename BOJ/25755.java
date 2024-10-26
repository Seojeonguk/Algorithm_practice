import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final char[] REVERSES = {'0', '1', '5', '?', '?', '2', '?', '?', '8', '?'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            char reverseDirection = st.nextToken().charAt(0);
            int arrSize = Integer.parseInt(st.nextToken());

            int[][] arr = new int[arrSize][arrSize];
            for (int i = 0; i < arrSize; i++) {
                StringTokenizer rows = new StringTokenizer(br.readLine());
                for (int j = 0; j < arrSize; j++) {
                    arr[i][j] = Integer.parseInt(rows.nextToken());
                }
            }

            if (reverseDirection == 'U' || reverseDirection == 'D') {
                for (int row = arrSize - 1; row >= 0; row--) {
                    for (int col = 0; col < arrSize; col++) {
                        sb.append(REVERSES[arr[row][col]]).append(" ");
                    }
                    sb.append("\n");
                }
            } else {
                for (int row = 0; row < arrSize; row++) {
                    for (int col = arrSize - 1; col >= 0; col--) {
                        sb.append(REVERSES[arr[row][col]]).append(" ");
                    }
                    sb.append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
