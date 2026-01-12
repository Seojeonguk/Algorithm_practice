import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int currentNum = Integer.parseInt(br.readLine());
        int time = 0;

        while (currentNum != 1) {
            if (currentNum % 2 == 0) {
                currentNum /= 2;
            } else {
                currentNum = 3 * currentNum + 1;
            }
            time += 1;
        }

        sb.append(time);

        bw.write(sb.toString());
        bw.flush();
    }
}
