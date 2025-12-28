import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int capitolMile = Integer.parseInt(br.readLine());
            int studentNum = Integer.parseInt(br.readLine());
            int temperature = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(capitolMile * 2);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
