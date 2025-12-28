import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    private static final int SKIP_FLOOR = 13;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int trueFloor = Integer.parseInt(br.readLine());
            int labelFloor = trueFloor;
            if(trueFloor >= SKIP_FLOOR) {
                labelFloor += 1;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(labelFloor);

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
