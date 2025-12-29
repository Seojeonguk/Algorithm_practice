import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final int TAKE_COST = 1550;
    private static final int DISCOUNT_COST = 0;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String takeOffStation = br.readLine();
            String takeOnStation = br.readLine();

            StringBuilder sb = new StringBuilder();
            sb.append(takeOffStation.compareTo(takeOnStation) == 0 ? DISCOUNT_COST : TAKE_COST);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
