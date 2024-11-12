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
            int toyCnt = Integer.parseInt(st.nextToken());
            int boxLimit = Integer.parseInt(st.nextToken());
            char[] toyColors = br.readLine().toCharArray();

            char[][] boxes = new char[3][boxLimit];
            int[] boxIndexes = new int[3];

            for (char color : toyColors) {
                int boxIdx = startBox(color);
                for (int i = 0; i < 3; i++) {
                    if (boxIndexes[(boxIdx + i) % 3] < boxLimit) {
                        boxIdx = (boxIdx + i) % 3;
                        break;
                    }
                }

                boxes[boxIdx][boxIndexes[boxIdx]++] = color;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < boxLimit; j++) {
                    if (Character.isAlphabetic(boxes[i][j])) {
                        sb.append(boxes[i][j]);
                    }
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int startBox(char color) {
        if (color == 'r') {
            return 1;
        } else if (color == 'p') {
            return 2;
        } else {
            return 0;
        }
    }
}
