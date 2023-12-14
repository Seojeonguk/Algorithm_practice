import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalChicken = Integer.parseInt(br.readLine());
        int innerSize = (int) Math.sqrt(totalChicken);
        if (innerSize * innerSize < totalChicken) {
            innerSize++;
        }

        for (int i = 0; i < innerSize + 2; i++) {
            for (int j = 0; j < innerSize + 2; j++) {
                sb.append((i == 0 || j == 0 || i == innerSize + 1 || j == innerSize + 1) ? "x" : ".");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
