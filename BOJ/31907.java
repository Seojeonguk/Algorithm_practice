import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final char[][] GIST = {{'G', '.', '.', '.'}, {'.', 'I', '.', 'T'}, {'.', '.', 'S', '.'}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int ratio = Integer.parseInt(br.readLine());
            for (int row = 0; row < GIST.length * ratio; row++) {
                for (int col = 0; col < GIST[row / ratio].length * ratio; col++) {
                    sb.append(GIST[row / ratio][col / ratio]);
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
