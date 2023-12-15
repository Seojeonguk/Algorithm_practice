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
        int availableBlocks = Integer.parseInt(br.readLine());
        int height = 0;
        int surfaceLength = 1;

        while (availableBlocks >= surfaceLength * surfaceLength) {
            availableBlocks -= surfaceLength * surfaceLength;
            height++;
            surfaceLength += 2;
        }

        sb.append(height);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
