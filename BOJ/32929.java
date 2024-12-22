import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String UOS = "UOS";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int x = Integer.parseInt(br.readLine());

            sb.append(UOS.charAt(((x - 1) % UOS.length())));

            bw.write(sb.toString());
        }
    }
}
