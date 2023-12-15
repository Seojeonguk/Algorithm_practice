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
        int collectionSize = Integer.parseInt(br.readLine());

        double[] averages = new double[collectionSize];
        for (int i = 0; i < collectionSize; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            averages[i] = a / b;
        }

        sb.append(Arrays.stream(averages).min().getAsDouble()).append(" ")
                .append(Arrays.stream(averages).max().getAsDouble()).append(" ")
                .append(Arrays.stream(averages).sum());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
