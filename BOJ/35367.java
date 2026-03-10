import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        char[][] snakeyStrings = new char[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            snakeyStrings[row] = br.readLine().toCharArray();
        }

        for (int col = 0; col < colSize; col++) {
            for (int row = 0; row < rowSize; row++) {
                if (snakeyStrings[row][col] != '.') {
                    sb.append(snakeyStrings[row][col]);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
