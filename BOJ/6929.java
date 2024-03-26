import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int height = Integer.parseInt(br.readLine());
        int j = -1;
        for (int i = 0; i < height; i++) {
            j += (height / 2 >= i ? 2 : -2);
            for (int k = 0; k < j; k++) {
                sb.append("*");
            }
            for (int k = 0; k < height * 2 - j * 2; k++) {
                sb.append(" ");
            }
            for (int k = 0; k < j; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
