import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] firstCell = br.readLine().toCharArray();
            char[] secondCell = br.readLine().toCharArray();

            int horizontalDiff = Math.abs(firstCell[0] - secondCell[0]);
            int verticalDiff = Math.abs(firstCell[1] - secondCell[1]);

            sb.append(Math.min(horizontalDiff, verticalDiff)).append(" ").append(Math.max(horizontalDiff, verticalDiff));

            bw.write(sb.toString());
        }
    }
}
