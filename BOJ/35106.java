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
        int round = Integer.parseInt(br.readLine());
        int[] counts = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < round * 3; i++) {
            int hand = Integer.parseInt(st.nextToken());
            counts[hand] += 1;
        }

        int max = 1;
        int min = 1;

        for (int i = 2; i <= 3; i++) {
            if (counts[max] < counts[i]) {
                max = i;
            }

            if (counts[min] > counts[i]) {
                min = i;
            }
        }

        sb.append(min).append("\n").append(max).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}
