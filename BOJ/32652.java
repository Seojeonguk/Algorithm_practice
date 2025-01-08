import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int continuousPartialCnt = Integer.parseInt(br.readLine());

            sb.append("AKA");

            for (int i = 0; i < continuousPartialCnt; i++) {
                sb.append("RAKA");
            }

            bw.write(sb.toString());
        }
    }
}
