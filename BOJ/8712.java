import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int lineCnt = Integer.parseInt(br.readLine());
            int[][] snakes = new int[lineCnt][lineCnt];

            int snake = 1;
            for (int i = 0; i < lineCnt; i++) {
                for (int j = 0; j < lineCnt; j++) {
                    int col = (i % 2 == 0 ? 0 : lineCnt - 1) + (i % 2 == 0 ? 1 : -1) * j;
                    snakes[i][col] = snake++;
                }
            }

            for (int i = 0; i < lineCnt; i++) {
                for (int j = 0; j < lineCnt; j++) {
                    sb.append(snakes[i][j]).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
