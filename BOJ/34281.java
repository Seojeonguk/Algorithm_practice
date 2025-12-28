import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int width = Integer.parseInt(br.readLine());
            int length = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(width * length);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
