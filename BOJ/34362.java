import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final double RISED_SEA_LEVEL = 0.3;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            double altitude = Double.parseDouble(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(altitude - RISED_SEA_LEVEL);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
