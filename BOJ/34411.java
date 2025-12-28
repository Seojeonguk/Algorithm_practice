import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int rockNum = Integer.parseInt(br.readLine());
            int paintCostPerLiter = Integer.parseInt(br.readLine());
            int budget = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(rockNum * paintCostPerLiter);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
