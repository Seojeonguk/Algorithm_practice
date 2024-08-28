import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int maxDisplay = Integer.parseInt(br.readLine());
            int initDisplay = Integer.parseInt(br.readLine());
            int likeDisplay = Integer.parseInt(br.readLine());

            sb.append(initDisplay <= likeDisplay ? likeDisplay - initDisplay : maxDisplay - initDisplay + likeDisplay);

            bw.write(sb.toString());
        }
    }
}
