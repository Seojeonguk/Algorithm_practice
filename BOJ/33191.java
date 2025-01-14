import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int budget = Integer.parseInt(br.readLine());
            int watermelon = Integer.parseInt(br.readLine());
            int pomegranates = Integer.parseInt(br.readLine());
            int nuts = Integer.parseInt(br.readLine());

            if (watermelon <= budget) {
                sb.append("Watermelon");
            } else if (pomegranates <= budget) {
                sb.append("Pomegranates");
            } else if (nuts <= budget) {
                sb.append("Nuts");
            } else {
                sb.append("Nothing");
            }

            bw.write(sb.toString());
        }
    }
}
