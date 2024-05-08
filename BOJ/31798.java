import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String[] problemValues = br.readLine().split(" ");
            int leftTop = Integer.parseInt(problemValues[0]);
            int rightTop = Integer.parseInt(problemValues[1]);
            int bottom = Integer.parseInt(problemValues[2]);

            if (bottom == 0) {
                sb.append((int) Math.sqrt(leftTop + rightTop));
            } else {
                sb.append(bottom * bottom - leftTop - rightTop);
            }

            bw.write(sb.toString());
        }
    }
}
