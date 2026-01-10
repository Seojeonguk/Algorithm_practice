import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            int arrSize = Integer.parseInt(br.readLine());
            if (arrSize == 0) {
                break;
            }

            int sum = 0;
            for (int i = 1; i <= arrSize; i++) {
                for (int j = 1; j <= arrSize; j++) {
                    sum += i * j;
                }
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
