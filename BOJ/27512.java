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

            StringTokenizer maps = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(maps.nextToken());
            int colSize = Integer.parseInt(maps.nextToken());

            sb.append(longestSnakeLength(rowSize, colSize));

            bw.write(sb.toString());
        }
    }

    public static int longestSnakeLength(int row, int col) {
        return row * col - (row % 2 == 1 && col % 2 == 1 ? 1 : 0);
    }
}
