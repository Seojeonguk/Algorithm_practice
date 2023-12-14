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
        String str = "";
        while ((str = br.readLine()) != null) {
            long[] arr = Arrays.stream(str.split(" ")).mapToLong(Long::parseLong).toArray();

            for (int i = 0; i < arr.length; i++) {
                sb.append((i == 0 ? 1L : arr[i - 1]) * arr[i] * (i == arr.length - 1 ? 1L : arr[i + 1])).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
