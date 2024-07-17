import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int playGroundHeight = Integer.parseInt(br.readLine());
            int playGroundWidth = Integer.parseInt(br.readLine());

            sb.append(100 * Math.min(playGroundHeight, playGroundWidth) / 2);

            bw.write(sb.toString());
        }
    }
}
